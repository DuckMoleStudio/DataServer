package DataServer.query;

import DataServer.entity.Route;
import DataServer.service.RouteService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RouteQuery implements GraphQLQueryResolver {
    @Autowired
    private RouteService routeService;
    public List<Route> getRoutes() {
        return this.routeService.getAllRoutes();
    }
    public Optional<Route> getRoute(final int id) {
        return this.routeService.getRoute(id);
    }
}
