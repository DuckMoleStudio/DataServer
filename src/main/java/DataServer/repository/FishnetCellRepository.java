package DataServer.repository;

import DataServer.entity.FishnetCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishnetCellRepository extends JpaRepository<FishnetCell, Integer> {
}
