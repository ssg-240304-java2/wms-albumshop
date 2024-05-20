package bangshop.music.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StockOutStatus {
    WAITING("접수중"),
    COMPLETE("완료");

    private final String description;
}
