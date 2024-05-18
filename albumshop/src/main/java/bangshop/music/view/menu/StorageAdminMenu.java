package bangshop.music.view.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum StorageAdminMenu {
    STORAGE_STOCK("1", "앨범 재고 확인"),
    ORDERS("2", "주문 내역 조회"),
    STOCK_IN("3", "앨범 입고"),
    STOCK_IN_LIST("4", "앨범 입고 내역 조회"),
    STOCK_OUT("5", "앨범 출고"),
    STOCK_OUT_LIST("6", "앨범 출고 내역 조회"),
    LOG_OUT("7","로그아웃"),
    ;

    private final String code;
    private final String title;

    public static StorageAdminMenu from(String code) {
        return Arrays.stream(StorageAdminMenu.values())
                .filter(it -> it.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("메뉴를 다시 확인해주세요."));
    }
}
