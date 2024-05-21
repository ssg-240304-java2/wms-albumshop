package bangshop.music.model.service;

import bangshop.music.model.dao.EmployeeMapper;
import bangshop.music.model.dao.OrderMapper;
import bangshop.music.model.dao.SearchMapper;
import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.dto.OrderDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class OrderService {

    public int order(String albumNo, int quantity, int employeeNo) {
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            int result = orderMapper.order(albumNo, quantity, employeeNo);

            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
            return result;
        }
    }

    public boolean insertStockOut(int employeeNo) {
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            int result = orderMapper.insertStockOut(employeeNo);

            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
            return result > 0;
        }
    }


}
