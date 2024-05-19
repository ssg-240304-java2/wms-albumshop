package bangshop.music.model.dao;

import bangshop.music.model.domain.StockOut;
import bangshop.music.model.domain.StockOutStatus;
import bangshop.music.model.dto.StockOutAndStorageDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockOutMapper {
    List<StockOutAndStorageDTO> findStockOuts(@Param("status") StockOutStatus status);

    int update(StockOut stockOut);

    StockOut orderById(@Param("orderNo") int orderNo);
}
