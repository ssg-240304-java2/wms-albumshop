package bangshop.music.model.service;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

import bangshop.music.model.dao.SearchMapper;
import bangshop.music.model.dto.AlbumDTO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class SearchService {

    SqlSession sqlSession = getSqlSession();

    public List<AlbumDTO> searchAlbumByTitle(String title) {
        SearchMapper searchMapper = sqlSession.getMapper(SearchMapper.class);

        List<AlbumDTO> albumList = searchMapper.searchAlbumByTitle(title);

        sqlSession.close();
        return albumList;
    }

    public List<AlbumDTO> searchAlbumBySinger(String singer) {

        SearchMapper searchMapper = sqlSession.getMapper(SearchMapper.class);

        List<AlbumDTO> albumList = searchMapper.searchAlbumBySinger(singer);

        sqlSession.close();
        return albumList;
    }

    public List<AlbumDTO> searchAlbumByNo(String albumNo) {

        SearchMapper searchMapper = sqlSession.getMapper(SearchMapper.class);

        List<AlbumDTO> albumList = searchMapper.searchAlbumByNo(albumNo);

        sqlSession.close();
        return albumList;
    }
}
