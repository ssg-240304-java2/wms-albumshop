package bangshop.music.model.service;

import bangshop.music.model.dao.StockOutMapper;
import bangshop.music.model.dto.StockOutAndStorageDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class DispatchService {

    public List<StockOutAndStorageDTO> findStockOuts() {
        SqlSession sqlSession = getSqlSession();
        StockOutMapper mapper = sqlSession.getMapper(StockOutMapper.class);
        List<StockOutAndStorageDTO> stockOuts = mapper.findStockOuts();
        sqlSession.close();
        return stockOuts;
    }
}
