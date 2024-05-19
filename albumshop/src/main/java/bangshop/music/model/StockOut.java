package bangshop.music.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StockOut {
    private int stockOutNo;
    private LocalDateTime stockOutDate;
    private StockOutStatus status;
    private int storageNo;
    private int orderNo;

    public StockOut(int storageNo, int orderNo) {
        this.status = StockOutStatus.WAITING;
        this.storageNo = storageNo;
        this.orderNo = orderNo;
    }
}
