package bangshop.music.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import bangshop.music.model.domain.StockOut;
import bangshop.music.model.domain.StockOutStatus;
import bangshop.music.model.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import bangshop.music.model.dao.AlbumStorageMapper;
import bangshop.music.model.dao.OrderMapper;
import bangshop.music.model.dao.StockOutMapper;
import bangshop.music.model.dao.StorageMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class yrTest {

    @Mock
    private AlbumStorageMapper albumStorageMapper;

    @Mock
    private OrderMapper orderMapper;

    @Mock
    private StockOutMapper stockOutMapper;

    @Mock
    private StorageMapper storageMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // 초기 데이터 삽입
        AlbumStorageDTO initialAlbumStorageDTO = new AlbumStorageDTO(1, 200, "1", 1, 2, "유승제마켓", "트리플엑스영록");

        AlbumDTO initialAlbumDTO = new AlbumDTO("1", "New Jeans", "뉴진스", new Date(), 1000);

        OrderDTO initialOrderDTO = new OrderDTO();
        initialOrderDTO.setOrderNo(1);
        initialOrderDTO.setStoreName("노영록 앨범마켓");
        initialOrderDTO.setAlbumNo("1");
        initialOrderDTO.setQuantity(200);
        initialOrderDTO.setOrderDate("2022-01-01");

        StorageDTO initialStorageDTO = new StorageDTO();
        initialStorageDTO.setStorageNo(1);
        initialStorageDTO.setStorageCode("1");
        initialStorageDTO.setType("1");

        LocalDateTime stockOutDate = LocalDateTime.parse("2024-05-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        StockOut initialStockOut = new StockOut();
        initialStockOut.setStockOutNo(1);
        initialStockOut.setStockOutDate(stockOutDate);
        initialStockOut.setOrderNo(1);
        initialStockOut.setStatus(StockOutStatus.WAITING);

        StockOutAndStorageDTO initialStockOutDTO = new StockOutAndStorageDTO();
        initialStockOutDTO.setStockOutNo(1);
        initialStockOutDTO.setAlbum(initialAlbumDTO);
        initialStockOutDTO.setOrder(initialOrderDTO);
        initialStockOutDTO.setStatus(StockOutStatus.WAITING);
        initialStockOutDTO.setStorage(initialStorageDTO);

        // Mock 설정
        doNothing().when(albumStorageMapper).update(any(AlbumStorageDTO.class));
        doNothing().when(albumStorageMapper).save(any(AlbumStorageDTO.class));
        when(albumStorageMapper.find(anyString(), anyInt())).thenReturn(Optional.of(initialAlbumStorageDTO));

        when(orderMapper.order(anyString(), anyInt(), anyInt())).thenReturn(1);
        when(orderMapper.getById(anyInt())).thenReturn(initialOrderDTO);

        when(stockOutMapper.update(any(StockOut.class))).thenReturn(1);
        when(stockOutMapper.findStockOuts(any(StockOutStatus.class))).thenReturn(Collections.singletonList(initialStockOutDTO));
        when(stockOutMapper.orderById(anyInt())).thenReturn(Optional.of(initialStockOut));

        when(storageMapper.findByType(anyString())).thenReturn(Optional.of(initialStorageDTO));
    }

    // AlbumStorageMapper 테스트
    @DisplayName("앨범창고가 업데이트 테스트")
    @Test
    public void testUpdateAlbumStorage() {
        // given
        AlbumStorageDTO albumStorageDTO = new AlbumStorageDTO(1, 300, "1", 1, 3, "마켓컬리", "송재혁");

        // when
        albumStorageMapper.update(albumStorageDTO);

        // then
        verify(albumStorageMapper, times(1)).update(albumStorageDTO);
    }

    @DisplayName("앨범창고가 없으면 저장 테스트")
    @Test
    public void testSaveAlbumStorage() {
        // given
        AlbumStorageDTO albumStorageDTO = new AlbumStorageDTO(2, 400, "2", 2, 3, "알리익스프레스", "육슬찬");

        // when
        albumStorageMapper.save(albumStorageDTO);

        // then
        verify(albumStorageMapper, times(1)).save(albumStorageDTO);
    }

    @DisplayName("앨범창고를 찾을수 있는지 테스트")
    @Test
    public void testFindAlbumStorage() {
        // given
        String albumNo = "1";
        int storageNo = 1;

        // when
        Optional<AlbumStorageDTO> result = albumStorageMapper.find(albumNo, storageNo);

        // then
        assertTrue(result.isPresent());
        assertEquals(albumNo, result.get().getAlbumNo());
        verify(albumStorageMapper, times(1)).find(albumNo, storageNo);
    }

    // OrderMapper 테스트
    @DisplayName("주문이 제대로 들어가는가에 대한 테스트")
    @Test
    public void testOrder() {
        // given
        String albumNo = "2";
        int quantity = 150;
        int employeeNo = 2;

        // when
        int result = orderMapper.order(albumNo, quantity, employeeNo);

        // then
        assertEquals(1, result);
        verify(orderMapper, times(1)).order(albumNo, quantity, employeeNo);
    }

    @DisplayName("주문이 ID에 따라 불러올수 있는지 테스트")
    @Test
    public void testGetOrderById() {
        // given
        int orderNo = 1;

        // when
        OrderDTO result = orderMapper.getById(orderNo);

        // then
        assertNotNull(result);
        assertEquals(orderNo, result.getOrderNo());
        verify(orderMapper, times(1)).getById(orderNo);
    }

    // StockOutMapper 테스트
    @DisplayName("출고가 제대로 업데이트 되는지 테스트")
    @Test
    public void testUpdateStockOut() {
        // given
        StockOut stockOut = new StockOut();
        stockOut.setStockOutNo(1);
        stockOut.setStockOutDate(LocalDateTime.parse("2024-05-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        stockOut.setOrderNo(1);
        stockOut.setStatus(StockOutStatus.COMPLETE);

        // when
        int result = stockOutMapper.update(stockOut);

        // then
        assertEquals(1, result);
        verify(stockOutMapper, times(1)).update(stockOut);
    }

    @DisplayName("출고를 제대로 찾을수 있는지 테스트")
    @Test
    public void testFindStockOuts() {
        // given
        StockOutStatus status = StockOutStatus.WAITING;

        // when
        List<StockOutAndStorageDTO> result = stockOutMapper.findStockOuts(status);

        // then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(stockOutMapper, times(1)).findStockOuts(status);
    }

    @DisplayName("출고주문을 id로 찾을수 있는지 테스트")
    @Test
    public void testOrderById() {
        // given
        int orderNo = 1;

        // when
        Optional<StockOut> result = stockOutMapper.orderById(orderNo);

        // then
        assertTrue(result.isPresent());
        assertEquals(orderNo, result.get().getStockOutNo());
        verify(stockOutMapper, times(1)).orderById(orderNo);
    }

    // StorageMapper 테스트
    @DisplayName("창고 구분으로 창고를 찾을수 있는지 테스트")
    @Test
    public void testFindByType() {
        // given
        String type = "1";

        // when
        Optional<StorageDTO> result = storageMapper.findByType(type);

        // then
        assertTrue(result.isPresent());
        assertEquals(type, result.get().getType());
        verify(storageMapper, times(1)).findByType(type);
    }
}
