package bangshop.music.model.dao;

import bangshop.music.model.dto.AlbumDTO;

import java.util.List;

public interface dao {
    List<AlbumDTO> storeStoragefindAll();
    List<AlbumDTO> findAlbumByArtist(String artist);
}
