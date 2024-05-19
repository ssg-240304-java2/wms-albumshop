package bangshop.music.model.dao;

import bangshop.music.model.dto.AlbumStorageDTO;
import org.apache.ibatis.annotations.Param;

public interface AlbumStorageMapper {
    AlbumStorageDTO find(@Param("albumNo") String albumNo, @Param("storageNo") int storageNo);

    void update(AlbumStorageDTO albumStorage);
}
