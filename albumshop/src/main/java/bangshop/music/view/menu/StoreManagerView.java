package bangshop.music.view.menu;

import bangshop.music.common.utils.IOUtils;
import bangshop.music.controller.OrderStorageController;
import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.EmployeeDTO;

import bangshop.music.controller.SearchController;

import java.util.List;

public class StoreManagerView {
    private SearchController searchController = new SearchController();

    public void storeManagerMenu(EmployeeDTO emp) {
        while (true) {
            displayMenu();
            String inputMenu = IOUtils.input("메뉴를 입력하세요: ");
            StoreManagerMenu menu = StoreManagerMenu.from(inputMenu);

            switch (menu) {
                case SEARCH_ALBUM -> searchAlbum();//TODO: 앨범 검색 및 조회
                case ORDERS -> order();
                case STOCK_INFO -> OrderStorageController.findstoreStock(emp.getEmployeeNo());//TODO: 앨범 재고 조회
                case LOG_OUT -> {
                    System.out.println();
                    return;
                }
            }
        }
    }

    private void order() {
        System.out.println("========== 앨범 주문 메뉴 ==========");
        String albumNo = IOUtils.input("앨범 번호: ");
        int quantity = Integer.parseInt(IOUtils.input("수량: "));
    }

    private static void displayMenu() {
        System.out.println("==========점장메뉴 메뉴==========");
        for (StoreManagerMenu menu : StoreManagerMenu.values()) {
            System.out.println(menu.getCode() + ". " + menu.getTitle());
        }
    }

    private void searchAlbum() {
        System.out.println("========== 앨범 검색 메뉴 ==========");
        System.out.println("1. 가수로 검색");
        System.out.println("2. 제목으로 검색");
        System.out.println("3. 앨범 번호로 검색");

        String inputMenu = IOUtils.input("메뉴를 입력하세요: ");
        switch (inputMenu) {
            case "1"-> searchController.searchAlbumBySinger();
            case "2" -> searchController.searchAlbumByTitle();
            case "3"-> searchController.searchAlbumByNo();
        }

    }

    public static void displayStorage(List<AlbumStorageDTO> storage) {
        if (storage == null || storage.isEmpty()) {
            System.out.println("> 😅😅😅 조회된 재고가 없습니다. 😅😅😅");
        } else {
            System.out.println("----------------------------");
            for (AlbumStorageDTO albumStorage : storage) {
                System.out.println(albumStorage);
            }
            System.out.println("----------------------------");
        }
    }
}
