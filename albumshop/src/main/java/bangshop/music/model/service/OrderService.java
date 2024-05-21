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

    SqlSession sqlSession = getSqlSession();

    public int order(String albumNo, int quantity , int employeeNo) {
        try (SqlSession sqlSession = getSqlSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            int result = orderMapper.order(albumNo, quantity, employeeNo);

            sqlSession.commit();
            return result;
        }
    }
}
