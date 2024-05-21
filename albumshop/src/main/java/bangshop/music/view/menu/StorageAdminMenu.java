package bangshop.music.view.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum StorageAdminMenu {
    SHOW_ALBUM("0", "앨범 목록"),
    REGISTER_ALBUM("1","앨범 입고"),
    STORAGE_STOCK("2", "앨범 재고 확인"),
    STOCK_IN("3", "앨범 재고 변경"),
    STOCK_IN_LIST("4", "앨범 입고 내역 조회"),
    ORDERS("5", "주문 내역 조회"),
    STOCK_OUT("6", "앨범 출고"),
    STOCK_OUT_LIST("7", "앨범 출고 내역 조회"),
    CREATE_ACCOUNT("8", "계정 생성"),
    SEARCH_STORE("9", "지점 검색"),
    SEARCH_EMPLOYEE("10", "직원 검색"),
    LOG_OUT("q","로그아웃"),
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
