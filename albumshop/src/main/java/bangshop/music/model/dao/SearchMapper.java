package bangshop.music.model.dao;

import bangshop.music.model.dto.AlbumDTO;
import java.util.List;

public interface SearchMapper {
    List<AlbumDTO> searchAlbumByTitle(String Title);
//    List<AlbumDTO> searchAlbumByTrack(String Track);
    List<AlbumDTO> searchAlbumByNo(String albumNo);
    List<AlbumDTO> searchAlbumBySinger(String singer);
}
