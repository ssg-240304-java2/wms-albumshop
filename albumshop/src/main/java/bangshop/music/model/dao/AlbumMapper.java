package bangshop.music.model.dao;

import bangshop.music.model.dto.AlbumDTO;

public interface AlbumMapper {
    Integer insertAlbum(AlbumDTO request);

    boolean isExistAlbum(String albumNo);
}
