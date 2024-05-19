package bangshop.music.model.dao;

import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.OrderDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderStorageMapper {
    List<AlbumStorageDTO> findStorageStock(String number);

    // 직원의 창고 번호 가져오기
    Integer getStorageNoByEmployeeNo(@Param("employee_no") int employeeNo);

    // 창고의 앨범 재고 조회
    List<Map<String, Object>> getAlbumStockByStorageNo(@Param("storage_no") int storageNo);

    List<OrderDTO> findOrder();
}
