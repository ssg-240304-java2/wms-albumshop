package bangshop.music.view.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum StoreManagerMenu {
    SEARCH_ALBUM("1", "앨범 검색 및 조회"),
    ORDERS("2", "앨범 주문"),
    STOCK_INFO("3", "앨범 재고 조회"),
    LOG_OUT("0","로그아웃"),
    ;
    private final String code;
    private final String title;

    public static StoreManagerMenu from(String code) {
        return Arrays.stream(StoreManagerMenu.values())
                .filter(it -> it.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("메뉴를 다시 확인해주세요."));
    }

}
