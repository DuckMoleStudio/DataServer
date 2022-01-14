package DataServer.service;

import DataServer.entity.Route;
import DataServer.repository.RouteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    private final RouteRepository routeRepository ;
    public RouteService(final RouteRepository routeRepository) {
        this.routeRepository = routeRepository ;
    }

    @Transactional(readOnly = true)
    public List<Route> getAllRoutes() {
        return this.routeRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Route> getRoute(final int id) {
        return this.routeRepository.findById(id);
    }
}

