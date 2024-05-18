package bangshop.music.view.menu;

import bangshop.music.common.utils.IOUtils;

public class StorageAdminView {

    public void storageAdminMenu() {
        while (true) {
            displayMenu();
            String inputMenu = IOUtils.input("메뉴를 입력하세요: ");
            StorageAdminMenu menu = StorageAdminMenu.from(inputMenu);

            switch (menu) {
//                case STORAGE_STOCK ->//TODO: 앨범 재고 확인
//                case ORDERS ->//TODO: 주문 내역 조회
//                case STOCK_IN ->//TODO: 앨범 입고
//                case STOCK_IN_LIST ->//TODO: 앨범 입고 내역 조회
//                case STOCK_OUT -> //TODO: 앨범 출고
//                case STOCK_OUT_LIST ->//TODO: 앨범 출고 내역 조회
                case LOG_OUT -> {
                    return;
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("==========창고관리자 메뉴==========");
        for (StorageAdminMenu menu : StorageAdminMenu.values()) {
            System.out.println(menu.getCode() + ". " + menu.getTitle());
        }
    }
}
