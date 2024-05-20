package bangshop.music.model.service;

import bangshop.music.model.dao.SearchMapper;
import bangshop.music.model.dto.AlbumDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class OrderService {

        SqlSession sqlSession = getSqlSession();
    public List<AlbumDTO> searchAlbumByTitle(String title) {
        SearchMapper searchMapper = sqlSession.getMapper(SearchMapper.class);

        List<AlbumDTO> albumList = searchMapper.searchAlbumByTitle(title);

        sqlSession.close();
        return albumList;
    }

    public void order(String albumNo, int quantity ) {
//        emp store
    }
}
