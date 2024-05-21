package bangshop.music.controller;

import bangshop.music.model.dao.OrderStorageMapper;
import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.OrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class jhTest {
    @Mock
    private OrderStorageMapper orderStorageMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("본사창고의 재고가 제대로 보이는지")
    @Test
    public void testFindStorageStock() {
        AlbumStorageDTO albumStorage = new AlbumStorageDTO();
        albumStorage.setStorageNo(2);

        when(orderStorageMapper.getStorageStock(2)).thenReturn(Collections.singletonList(albumStorage));

        List<AlbumStorageDTO> storageStocks = orderStorageMapper.getStorageStock(2);
        assertNotNull(storageStocks);
        assertEquals(1,storageStocks.size());
        assertEquals(2, storageStocks.get(0).getStorageNo());
    }

    @DisplayName("주문내역이 제대로 나오는지")
    @Test
    public void testFindOrder() {
        OrderDTO order = new OrderDTO();
        order.setOrderNo(1);

        when(orderStorageMapper.findOrder()).thenReturn(Collections.singletonList(order));

        List<OrderDTO> orders = orderStorageMapper.findOrder();
        assertNotNull(orders);
        assertEquals(1, orders.size());
        assertEquals(1, orders.get(0).getOrderNo());
    }

    @DisplayName("가맹점창고의 재고가 제대로 보이는지")
    @Test
    public void testGetStoreStock() {
        AlbumStorageDTO albumStorage = new AlbumStorageDTO();
        albumStorage.setStorageNo(1);

        when(orderStorageMapper.getStoreStock(1)).thenReturn(Collections.singletonList(albumStorage));

        List<AlbumStorageDTO> albumStocks = orderStorageMapper.getStoreStock(1);
        assertNotNull(albumStocks);
        assertEquals(1, albumStocks.size());
        assertEquals(1, albumStocks.get(0).getStorageNo());
    }
}
