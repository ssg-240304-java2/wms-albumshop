package bangshop.music.model.service;

import bangshop.music.model.dao.AlbumStorageMapper;
import bangshop.music.model.dao.OrderMapper;
import bangshop.music.model.dao.StockOutMapper;
import bangshop.music.model.dao.StorageMapper;
import bangshop.music.model.domain.StockOut;
import bangshop.music.model.domain.StockOutStatus;
import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.OrderDTO;
import bangshop.music.model.dto.StockOutAndStorageDTO;
import bangshop.music.model.dto.StorageDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class DispatchService {

    public List<StockOutAndStorageDTO> findStockOuts(StockOutStatus status) {
        try (SqlSession sqlSession = getSqlSession()) {
            StockOutMapper mapper = sqlSession.getMapper(StockOutMapper.class);

            return mapper.findStockOuts(status);
        }
    }

    public int dispatch(int orderNo) {
        try (SqlSession sqlSession = getSqlSession()) {
            StockOutMapper stockOutMapper = sqlSession.getMapper(StockOutMapper.class);
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            AlbumStorageMapper albumStorageMapper = sqlSession.getMapper(AlbumStorageMapper.class);
            StorageMapper storageMapper = sqlSession.getMapper(StorageMapper.class);

            StockOut stockOut = stockOutMapper.orderById(orderNo)
                    .orElseThrow(() -> new IllegalArgumentException("출고 리스트에 존재하지 않습니다."));
            OrderDTO order = orderMapper.getById(stockOut.getOrderNo());

            Optional<AlbumStorageDTO> albumStorageDTO = albumStorageMapper.find(order.getAlbumNo(), stockOut.getStorageNo());
            if (albumStorageDTO.isPresent()) {
                AlbumStorageDTO albumStorage = albumStorageDTO.get();
                albumStorage.increaseStock(order.getQuantity());
                albumStorageMapper.update(albumStorage);
            } else {
                AlbumStorageDTO albumStorage = AlbumStorageDTO.from(order);
                albumStorageMapper.save(albumStorage);
            }

            int storageNo = storageMapper.findByType("본사창고")
                    .map(StorageDTO::getStorageNo)
                    .orElseThrow(() -> new IllegalStateException("본사 창고를 찾을 수 없습니다."));

            AlbumStorageDTO headquartersStorage = albumStorageMapper.find(order.getAlbumNo(), storageNo)
                    .orElseThrow(() -> new IllegalStateException("해당 앨범은 창고에 재고가 없습니다."));
            headquartersStorage.decreaseStock(order.getQuantity());
            albumStorageMapper.update(headquartersStorage);

            stockOut.complete();
            int result = stockOutMapper.update(stockOut);
            sqlSession.commit();
            return result;
        }
    }
}
