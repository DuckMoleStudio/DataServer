package DataServer.service;

import DataServer.entity.BusStop;
import DataServer.repository.BusStopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BusStopService {
    private final BusStopRepository busStopRepository ;
    public BusStopService(final BusStopRepository busStopRepository) {
        this.busStopRepository = busStopRepository ;
    }

    @Transactional(readOnly = true)
    public List<BusStop> getAllBusStops() {
        return this.busStopRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<BusStop> getBusStop(final int id) {
        return this.busStopRepository.findById(id);
    }
}
