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

    public static List<AlbumStorageDTO> findStorageStock(String number) {
        try (SqlSession sqlSession = getSqlSession()) {
            OrderStorageMapper orderStorageMapper = sqlSession.getMapper(OrderStorageMapper.class);
            List<AlbumStorageDTO> stock = orderStorageMapper.findStorageStock(number);
            sqlSession.close();
            return stock;
        }
    }

    public static List<Map<String, Object>> findStoreAlbumStock(EmployeeDTO employee) {
        try (SqlSession sqlSession = MyBatisTemplate.getSqlSession()) {
            OrderStorageMapper orderStorageMapper = sqlSession.getMapper(OrderStorageMapper.class);

            // 점장의 가맹점 앨범 재고 조회
            return orderStorageMapper.getStoreAlbumStock(employee.getEmployeeNo());
        }
    }
}
