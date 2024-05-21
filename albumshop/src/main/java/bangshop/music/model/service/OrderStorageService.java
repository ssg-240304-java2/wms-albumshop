package bangshop.music.model.service;

import bangshop.music.common.MyBatisTemplate;
import bangshop.music.model.dao.OrderStorageMapper;
import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.dto.OrderDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class OrderStorageService {

    public static List<OrderDTO> findOrder() {
        try (SqlSession sqlSession = getSqlSession()) {
            OrderStorageMapper orderStorageMapper = sqlSession.getMapper(OrderStorageMapper.class);
            List<OrderDTO> orderList = orderStorageMapper.findOrder();
            sqlSession.close();
            return orderList;
        }
    }

    public static List<AlbumStorageDTO> getStorageStock(int number) {
        try (SqlSession sqlSession = getSqlSession()) {
            OrderStorageMapper orderStorageMapper = sqlSession.getMapper(OrderStorageMapper.class);
            List<AlbumStorageDTO> stock = orderStorageMapper.getStorageStock(number);
            sqlSession.close();
            return stock;
        }
    }

    public static List<AlbumStorageDTO> getStoreStock(int employeeId) {
        try (SqlSession sqlSession = getSqlSession()) {
            OrderStorageMapper orderStorageMapper = sqlSession.getMapper(OrderStorageMapper.class);
            List<AlbumStorageDTO> stock = orderStorageMapper.getStoreStock(employeeId);
            sqlSession.close();
            return stock;
        }
    }
}
