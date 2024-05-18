package bangshop.music.model.service;

import bangshop.music.model.dao.dao;
import bangshop.music.model.dto.AlbumDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class Service {

    public List<AlbumDTO> findStoreStorage() {
        SqlSession sqlSession = getSqlSession();
        dao dao = sqlSession.getMapper(dao.class);
        List<AlbumDTO> list = dao.storeStoragefindAll();
        sqlSession.close();
        return list;
    }
}
