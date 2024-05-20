package bangshop.music.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {

    STOCK_ERROR("재고조회중 오류가 발생했습니다"),
    ORDER_ERROR("주문조회중 오류가 발생했습니다");

    @Getter // 필드레벨에 작성 (특정 필드만 getter생성)
    final String msg;
}
