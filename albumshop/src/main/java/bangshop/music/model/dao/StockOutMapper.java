package bangshop.music.model.dao;

import bangshop.music.model.dto.StockOutAndStorageDTO;

import java.util.List;

public interface StockOutMapper {
    List<StockOutAndStorageDTO> findStockOuts();
}
