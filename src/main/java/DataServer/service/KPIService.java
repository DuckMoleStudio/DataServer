package DataServer.service;

import DataServer.entity.FishnetCell;
import DataServer.kpi.KPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class KPIService {


    @Autowired
    private FishnetCellService fishnetCellService;

    @Transactional(readOnly = true)
    public KPI getKPI(final int limitStops,
                      final int limitMetroBus,
                      final int limitMetroBusFoot,
                      final int limitMetroCar) {


        int reachableStops = 0;
        int reachableMetroBus = 0;
        int reachableMetroBusFoot = 0;
        int reachableMetroCar = 0;

        int homeTotal = 0;

        List<FishnetCell> allCells = this.fishnetCellService.getAllFishnetCells();

        for(FishnetCell cell: allCells)
        {
            homeTotal+=cell.getHome();

            if(cell.getMinStopDist()<=limitStops)
               reachableStops+=cell.getHome();
            if(cell.getMetroSimple()<=limitMetroBus)
                reachableMetroBus+=cell.getWork();
            if(cell.getMetroFull()<=limitMetroBusFoot)
                reachableMetroBusFoot+=cell.getWork();
            if(cell.getMetroCar()<=limitMetroCar)
                reachableMetroCar+=cell.getWork();

        }

        KPI result = new KPI();
        result.setReachableStops(reachableStops);
        result.setReachableMetroBus(reachableMetroBus);
        result.setReachableMetroBusFoot(reachableMetroBusFoot);
        result.setReachableMetroCar(reachableMetroCar);
        result.setTotalPopulation(homeTotal);

        return result;
    }
}
