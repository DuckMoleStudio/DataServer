package DataServer.query;

import DataServer.kpi.KPI;
import DataServer.service.KPIService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KPIQuery implements GraphQLQueryResolver {
    @Autowired
    private KPIService kpi_Service;

    public KPI getKpi(final int limitStops,
                      final int limitMetroBus,
                      final int limitMetroBusFoot,
                      final int limitMetroCar)
    {
        return this.kpi_Service.getKPI(limitStops,limitMetroBus,limitMetroBusFoot,limitMetroCar);
    }
}
