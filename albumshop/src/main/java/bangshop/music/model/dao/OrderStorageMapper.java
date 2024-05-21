package bangshop.music.model.dao;

import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.OrderDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderStorageMapper {
    List<AlbumStorageDTO> getStorageStock(int number);

    List<OrderDTO> findOrder();

    List<AlbumStorageDTO> getStoreStock(int employeeId);
}
