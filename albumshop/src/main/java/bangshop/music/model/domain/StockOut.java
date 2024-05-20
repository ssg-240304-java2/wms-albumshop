package bangshop.music.model.domain;

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

    public void complete() {
        if (this.status == StockOutStatus.COMPLETE) {
            throw new IllegalStateException("이미 출고 완료되었습니다.");
        }

        this.status = StockOutStatus.COMPLETE;
        this.stockOutDate = LocalDateTime.now();
    }
}
