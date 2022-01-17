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


        int reachableStopsHome = 0;
        int reachableMetroBusHome = 0;
        int reachableMetroBusFootHome = 0;
        int reachableMetroCarHome = 0;

        int homeTotal = 0;

        int reachableStopsWork = 0;
        int reachableMetroBusWork = 0;
        int reachableMetroBusFootWork = 0;
        int reachableMetroCarWork = 0;

        int workTotal = 0;

        List<FishnetCell> allCells = this.fishnetCellService.getAllFishnetCells();

        for(FishnetCell cell: allCells)
        {
            homeTotal+=cell.getHome();
            workTotal+=cell.getWork();

            if(cell.getMinStopDist()<=limitStops)
            {
                reachableStopsHome+=cell.getHome();
                reachableStopsWork+=cell.getWork();
            }
            if(cell.getMetroSimple()<=limitMetroBus)
            {
                reachableMetroBusHome+=cell.getHome();
                reachableMetroBusWork+=cell.getWork();
            }
            if(cell.getMetroFull()<=limitMetroBusFoot)
            {
                reachableMetroBusFootHome+=cell.getHome();
                reachableMetroBusFootWork+=cell.getWork();
            }
            if(cell.getMetroCar()<=limitMetroCar)
            {
                reachableMetroCarHome+=cell.getHome();
                reachableMetroCarWork+=cell.getWork();
            }

        }

        KPI result = new KPI();
        result.setBusStopsFootHome(reachableStopsHome);
        result.setBusStopsFootWork(reachableStopsWork);
        result.setToMetroBusHome(reachableMetroBusHome);
        result.setToMetroBusWork(reachableMetroBusWork);
        result.setToMetroBusFootHome(reachableMetroBusFootHome);
        result.setToMetroBusFootWork(reachableMetroBusFootWork);
        result.setToMetroCarHome(reachableMetroCarHome);
        result.setToMetroCarWork(reachableMetroCarWork);
        result.setHomeTotal(homeTotal);
        result.setWorkTotal(workTotal);

        return result;
    }
}
