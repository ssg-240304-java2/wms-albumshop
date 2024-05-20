package bangshop.music.model.dao;

import bangshop.music.model.domain.StockOut;
import bangshop.music.model.domain.StockOutStatus;
import bangshop.music.model.dto.StockOutAndStorageDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface StockOutMapper {
    List<StockOutAndStorageDTO> findStockOuts(@Param("status") StockOutStatus status);

    int update(StockOut stockOut);

    Optional<StockOut> orderById(@Param("orderNo") int orderNo);
}
