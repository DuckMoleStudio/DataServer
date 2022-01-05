package DataServer.service;

import DataServer.entity.FishnetCell;
import DataServer.kpi.KPI_01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class KPI_01Service {


    @Autowired
    private FishnetCellService fishnetCellService;




    @Transactional(readOnly = true)
    public KPI_01 getKPI_01(final int slider) {
        int workReachable = 0;
        int homeReachable = 0;
        int workTotal = 0;
        int homeTotal = 0;

        List<FishnetCell> allCells = this.fishnetCellService.getAllFishnetCells();

        for(FishnetCell cell: allCells)
        {
            homeTotal+=cell.getHome();
            workTotal+=cell.getWork();
            if(cell.getMinStopDist()<=slider)
            {
                homeReachable+=cell.getHome();
                workReachable+=cell.getWork();
            }
        }

        KPI_01 result = new KPI_01();
        result.setHomeReachable(homeReachable);
        result.setWorkReachable(workReachable);
        result.setHomeTotal(homeTotal);
        result.setWorkTotal(workTotal);
        result.setHomeRatio((homeReachable * 100) / homeTotal);
        result.setWorkRatio((workReachable * 100) / workTotal);

        return result;
    }
}
