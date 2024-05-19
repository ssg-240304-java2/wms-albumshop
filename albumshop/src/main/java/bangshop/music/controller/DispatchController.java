package bangshop.music.controller;

import bangshop.music.model.dto.StockOutAndStorageDTO;
import bangshop.music.model.service.DispatchService;

import java.util.List;

public class DispatchController {
    private final DispatchService dispatchService = new DispatchService();

    public void findStockOuts() {
        System.out.println("================================");
        List<StockOutAndStorageDTO> stockOuts = dispatchService.findStockOuts();

        for (StockOutAndStorageDTO stockOut : stockOuts) {
            System.out.println(
                    "출고 번호: " + stockOut.getStockOutNo() + ", " +
                            "주문 번호: " + stockOut.getOrder().getOrderNo() + ", " +
                            "앨범 정보: " + stockOut.getOrder().getAlbumNo() + ", " +
                            "주문 수량: " + stockOut.getOrder().getQuantity() + ", " +
                            "출고 상태: " + stockOut.getStatus().getDescription() + ", " +
                            "출고 일자: " + stockOut.getStockOutDate() + ", " +
                            "창고 번호: " + stockOut.getStorage().getStorageNo() + ", "
            );
        }
    }
}
