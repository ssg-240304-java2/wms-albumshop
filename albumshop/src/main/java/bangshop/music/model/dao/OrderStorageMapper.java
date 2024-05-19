package bangshop.music.model.dao;

import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.OrderDTO;

import java.util.List;

public interface OrderStorageMapper {
    List<AlbumStorageDTO> findStoreStorage(String number);

    List<OrderDTO> findOrder();
}
