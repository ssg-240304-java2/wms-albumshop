package bangshop.music.model.dao;

import bangshop.music.model.dto.AlbumStorageDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface AlbumStorageMapper {
    Optional<AlbumStorageDTO> find(@Param("albumNo") String albumNo, @Param("storageNo") int storageNo);

    void update(AlbumStorageDTO albumStorage);

    void save(AlbumStorageDTO albumStorage);
}
