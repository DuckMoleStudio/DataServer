package DataServer.query;

import DataServer.kpi.KPI_01;
import DataServer.service.KPI_01Service;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KPI_01Query implements GraphQLQueryResolver {
    @Autowired
    private KPI_01Service kpi_01Service;

    public KPI_01 getKpi_01(final int slider) {
        return this.kpi_01Service.getKPI_01(slider);
    }
}
