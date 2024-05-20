package bangshop.music.controller;

import bangshop.music.common.utils.IOUtils;
import bangshop.music.model.domain.StockOutStatus;
import bangshop.music.model.dto.StockOutAndStorageDTO;
import bangshop.music.model.service.DispatchService;

import java.util.List;

public class DispatchController {
    private final DispatchService dispatchService = new DispatchService();

    public void findStockOuts(StockOutStatus status) {
        List<StockOutAndStorageDTO> stockOuts = dispatchService.findStockOuts(status);
        if (stockOuts.isEmpty()) {
            throw new IllegalStateException("조회 결과가 없습니다.");
        }
        printStockOuts(stockOuts);
    }

    public void dispatch() {
        int orderNo = Integer.parseInt(IOUtils.input("출고할 주문 번호를 입력하세요: "));

        int result = dispatchService.dispatch(orderNo);
        if (result > 0) {
            System.out.println(orderNo + "- 출고 되었습니다.");
        }
    }

    private void printStockOuts(List<StockOutAndStorageDTO> stockOuts) {
        for (StockOutAndStorageDTO stockOut : stockOuts) {
            System.out.println(
                    "출고 번호: " + stockOut.getStockOutNo() + ", " +
                            "주문 번호: " + stockOut.getOrder().getOrderNo() + ", " +
                            "앨범 정보: " + stockOut.getOrder().getAlbumNo() + ", " +
                            "주문 수량: " + stockOut.getOrder().getQuantity() + ", " +
                            "출고 상태: " + stockOut.getStatus().getDescription() + ", " +
                            "출고 일자: " + stockOut.getStockOutDate() + ", " +
                            "창고 번호: " + stockOut.getStorage().getStorageNo()
            );
        }
    }

}
