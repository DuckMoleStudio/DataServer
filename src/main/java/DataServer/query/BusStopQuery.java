package DataServer.query;

import DataServer.entity.BusStop;
import DataServer.service.BusStopService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BusStopQuery implements GraphQLQueryResolver {
    @Autowired
    private BusStopService busStopService;
    public List<BusStop> getBusStops() {
        return this.busStopService.getAllBusStops();
    }
    public Optional<BusStop> getBusStop(final int id) {
        return this.busStopService.getBusStop(id);
    }
}
