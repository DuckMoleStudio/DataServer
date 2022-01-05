package DataServer.query;

import DataServer.entity.FishnetCell;
import DataServer.service.FishnetCellService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FishnetCellQuery implements GraphQLQueryResolver {
    @Autowired
    private FishnetCellService fishnetCellService;
    public List<FishnetCell> getFishnetCells() {
        return this.fishnetCellService.getAllFishnetCells();
    }
    public Optional<FishnetCell> getFishnetCell(final int id) {
        return this.fishnetCellService.getFishnetCell(id);
    }
}
