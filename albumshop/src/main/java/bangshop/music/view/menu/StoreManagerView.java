package bangshop.music.view.menu;

import bangshop.music.common.utils.IOUtils;

public class StoreManagerView {
    public void storeManagerMenu() {
        while (true) {
            displayMenu();
            String inputMenu = IOUtils.input("메뉴를 입력하세요: ");
            StoreManagerMenu menu = StoreManagerMenu.from(inputMenu);

            switch (menu) {
//                case SEARCH_ALBUM ->//TODO: 앨범 검색 및 조회
//                case ORDERS ->//TODO: 앨범 주문
//                case STOCK_INFO ->//TODO: 앨범 재고 조회
                case LOG_OUT -> {
                    return;
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("==========점장메뉴 메뉴==========");
        for (StoreManagerMenu menu : StoreManagerMenu.values()) {
            System.out.println(menu.getCode() + ". " + menu.getTitle());
        }
    }
}
