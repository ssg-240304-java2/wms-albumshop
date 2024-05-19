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

    public List<Map<String, Object>> getAlbumStock(int employeeNo) {
        try (SqlSession sqlSession = getSqlSession()) {
            OrderStorageMapper orderStorageMapper = sqlSession.getMapper(OrderStorageMapper.class);

            // 직원의 창고 번호 가져오기
            Integer storageNo = orderStorageMapper.getStorageNoByEmployeeNo(employeeNo);

            // 창고 번호가 유효한 경우 앨범 재고 조회
            if (storageNo != null) {
                return orderStorageMapper.getAlbumStockByStorageNo(storageNo);
            }

            return null; // 또는 예외 처리
        }
    }

    public static List<Map<String, Object>> findStoreStorage(EmployeeDTO employee) {
        try (SqlSession sqlSession = MyBatisTemplate.getSqlSession()) {
            OrderStorageMapper orderStorageMapper = sqlSession.getMapper(OrderStorageMapper.class);

            // 직원 번호를 기반으로 창고 번호 가져오기
            Integer storageNo = orderStorageMapper.getStorageNoByEmployeeNo(employee.getEmployeeNo());

            // 창고 번호가 유효한 경우 앨범 재고 조회
            if (storageNo != null) {
                return orderStorageMapper.getAlbumStockByStorageNo(storageNo);
            }

            return null; // 또는 예외 처리
        }
    }
}
