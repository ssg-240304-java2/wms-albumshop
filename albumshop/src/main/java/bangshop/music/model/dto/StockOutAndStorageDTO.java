package bangshop.music.model.dto;

import bangshop.music.model.domain.StockOutStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StockOutAndStorageDTO {
    private int stockOutNo;
    private LocalDate stockOutDate;
    private StockOutStatus status;
    private StorageDTO storage;
    private OrderDTO order;
}
