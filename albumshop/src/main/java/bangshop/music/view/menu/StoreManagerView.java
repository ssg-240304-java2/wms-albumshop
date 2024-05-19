package bangshop.music.view.menu;

import bangshop.music.common.utils.IOUtils;
import bangshop.music.controller.OrderStorageController;
import bangshop.music.model.dto.EmployeeDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

public class StoreManagerView {

    @Getter
    @Setter
    private static EmployeeDTO loggedInEmployee;

    public void storeManagerMenu() {
        while (true) {
            displayMenu();
            EmployeeDTO emp = new EmployeeDTO();
            String inputMenu = IOUtils.input("메뉴를 입력하세요: ");
            StoreManagerMenu menu = StoreManagerMenu.from(inputMenu);

            switch (menu) {
//                case SEARCH_ALBUM ->//TODO: 앨범 검색 및 조회
//                case ORDERS ->//TODO: 앨범 주문
                case STOCK_INFO -> OrderStorageController.findStoreAlbumStock();//TODO: 앨범 재고 조회
                case LOG_OUT -> {
                    System.out.println();
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

    public static void displayStoreAlbumStock(List<Map<String, Object>> storeStock) {
        if (storeStock != null && !storeStock.isEmpty()) {
            for (Map<String, Object> album : storeStock) {
                System.out.println("Album No: " + album.get("album_no"));
                System.out.println("Album Name: " + album.get("album_name"));
                System.out.println("Employee Name: " + album.get("name"));
                System.out.println("Singer: " + album.get("singer"));
                System.out.println("Release Date: " + album.get("release_date"));
                System.out.println("Price: " + album.get("price"));
                System.out.println("Stock: " + album.get("stock"));
                System.out.println("---------------------------------");
            }
        } else {
            System.out.println("No stock information available.");
        }
    }
}
