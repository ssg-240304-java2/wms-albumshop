package bangshop.music.model.dao;

import bangshop.music.model.dto.OrderDTO;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int order(@Param("albumNo") String albumNo, @Param("quantity") int quantity, @Param("employeeNo") int employeeNo);

    int insertStockOut(int employeeNo);

    OrderDTO getById(int orderId);
}