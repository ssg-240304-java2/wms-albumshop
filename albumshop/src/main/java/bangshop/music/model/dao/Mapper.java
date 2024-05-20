package bangshop.music.model.dao;

import bangshop.music.model.dto.StockInDTO;
import bangshop.music.model.dto.stock.GetStockRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Mapper {
    boolean isExistAlbum(@Param("albumNo") String albumNo);
    boolean isExistAlbumInStorage(String albumNo);
    Integer insertAlbumStorage(@Param("albumNo") String albumNo, @Param("quantity") Integer quantity);
    Integer updateAlbumStorage(@Param("albumNo") String albumNo, @Param("quantity") Integer quantity);
    Integer createStock(@Param("albumNo") String albumNo, @Param("quantity") Integer quantity);
    List<StockInDTO> getStockList(StockInDTO request);
}



