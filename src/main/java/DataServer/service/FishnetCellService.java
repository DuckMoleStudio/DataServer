package DataServer.service;

import DataServer.entity.FishnetCell;
import DataServer.repository.FishnetCellRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FishnetCellService {
    private final FishnetCellRepository fishnetCellRepository ;
    public FishnetCellService(final FishnetCellRepository fishnetCellRepository) {
        this.fishnetCellRepository = fishnetCellRepository ;
    }

    @Transactional(readOnly = true)
    public List<FishnetCell> getAllFishnetCells() {
        return this.fishnetCellRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<FishnetCell> getFishnetCell(final int id) {
        return this.fishnetCellRepository.findById(id);
    }
}
