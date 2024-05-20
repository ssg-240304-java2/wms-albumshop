package bangshop.music.model.service;

import bangshop.music.model.dao.AlbumStorageMapper;
import bangshop.music.model.dao.OrderMapper;
import bangshop.music.model.dao.StockOutMapper;
import bangshop.music.model.domain.StockOut;
import bangshop.music.model.domain.StockOutStatus;
import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.OrderDTO;
import bangshop.music.model.dto.StockOutAndStorageDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class DispatchService {

    public List<StockOutAndStorageDTO> findStockOuts(StockOutStatus status) {
        try (SqlSession sqlSession = getSqlSession()) {
            StockOutMapper mapper = sqlSession.getMapper(StockOutMapper.class);

            List<StockOutAndStorageDTO> stockOuts = mapper.findStockOuts(status);

            sqlSession.close();
            return stockOuts;
        }
    }

    public int dispatch(int orderNo) {
        try (SqlSession sqlSession = getSqlSession()) {
            StockOutMapper stockOutMapper = sqlSession.getMapper(StockOutMapper.class);
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            AlbumStorageMapper albumStorageMapper = sqlSession.getMapper(AlbumStorageMapper.class);

            StockOut stockOut = stockOutMapper.orderById(orderNo);
            if (stockOut == null) {
                throw new IllegalArgumentException("출고 리스트에 존재하지 않습니다.");
            }

//            OrderDTO orderDTO = orderMapper.getById(stockOut.getOrderNo());
            OrderDTO orderDTO = new OrderDTO();
            AlbumStorageDTO albumStorageDTO = albumStorageMapper.find(orderDTO.getAlbumNo(), stockOut.getStorageNo());
            albumStorageDTO.stockDecrease(orderDTO.getQuantity());
            albumStorageMapper.update(albumStorageDTO);



            stockOut.complete();
            int result = stockOutMapper.update(stockOut);

            sqlSession.commit();
            return result;
        }
    }
}
