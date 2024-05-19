package bangshop.music.model.service;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

import bangshop.music.model.dao.SearchMapper;
import bangshop.music.model.dao.dao;
import bangshop.music.model.dto.AlbumDTO;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class SearchService {

    public List<AlbumDTO> searchAlbumByTitle(String title) {
        SqlSession sqlSession = getSqlSession();
        SearchMapper searchMapper = sqlSession.getMapper(SearchMapper.class);
        List<AlbumDTO> albumList = searchMapper.searchAlbumByTitle(title);
        sqlSession.close();
        return albumList;
    }
}
