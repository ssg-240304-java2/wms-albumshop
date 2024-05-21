package bangshop.music.view.menu;

import bangshop.music.common.utils.IOUtils;
import bangshop.music.controller.DispatchController;
import bangshop.music.controller.EmployeeController;
import bangshop.music.controller.OrderStorageController;
import bangshop.music.controller.StorageController;

import bangshop.music.model.domain.StockOutStatus;
import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.OrderDTO;
import bangshop.music.model.dto.StockInDTO;
import bangshop.music.model.dto.stock.InsertStockRequest;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static bangshop.music.view.menu.MainMenu.inputAccountInfo;

public class StorageAdminView {
    private final DispatchController dispatchController = new DispatchController();
    private final StorageController storageController = new StorageController();

    public void storageAdminMenu() {
        EmployeeController employeeController = new EmployeeController();

        while (true) {
            try {
                displayMenu();
                String inputMenu = IOUtils.input("메뉴를 입력하세요: ");
                StorageAdminMenu menu = StorageAdminMenu.from(inputMenu);

                System.out.println("===============================");
                switch (menu) {
                    case REGISTER_ALBUM -> storageController.insertAlbum(inputAlbum());
                    case STORAGE_STOCK -> OrderStorageController.getStorageStock(2);
                    case ORDERS -> OrderStorageController.findOrder();
                    case STOCK_IN -> storageController.insertStock(inStockAlbum());
                    case STOCK_IN_LIST -> storageController.getStockList(new StockInDTO());
                    case STOCK_OUT -> {
                        dispatchController.findStockOuts(StockOutStatus.WAITING);
                        dispatchController.dispatch();
                    }
                    case STOCK_OUT_LIST -> dispatchController.findStockOuts(StockOutStatus.COMPLETE);
                    case CREATE_ACCOUNT -> employeeController.createAccount(inputEmployeeInfo());
                    case SEARCH_STORE -> employeeController.findStoreByKeyword(inputKeyword());
                    case SEARCH_EMPLOYEE -> employeeController.findEmployeeByName(inputEmployeeName());
                    case LOG_OUT -> {
                        System.out.println();
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private AlbumDTO inputAlbum() {
        Scanner sc = new Scanner(System.in);
        AlbumDTO album = null;

        String no = IOUtils.input("1. 앨범번호를 입력하세요 : ");
        String name = IOUtils.input("2. 앨범명을 입력하세요 : ");
        String singer = IOUtils.input("3. 가수를 입력하세요 : ");
        Date date = Date.valueOf(IOUtils.input("4. 발매일을 입력하세요 : "));
        int price = Integer.parseInt(IOUtils.input("5. 가격을 입력하세요 : "));

        album = new AlbumDTO(no, name, singer, date, price );

        return album;
    }

    private InsertStockRequest inStockAlbum() {

        Scanner sc = new Scanner(System.in);
        InsertStockRequest stock = null;
        try {
            String albumNo = IOUtils.input("입고할 앨범 코드를 입력하세요 : ");
            int quantity = Integer.parseInt( IOUtils.input("입고할 수량을 입력하세요 : "));
            stock = new InsertStockRequest(albumNo, quantity);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 다시 시도해 주세요.");
        }
        return stock;
    }

    private static void displayMenu() {
        System.out.println("==========창고관리자 메뉴==========");
        for (StorageAdminMenu menu : StorageAdminMenu.values()) {
            System.out.println(menu.getCode() + ". " + menu.getTitle());
        }
    }

    private Map<String, String> inputEmployeeInfo() {
        String name = IOUtils.input("이름을 입력하세요: ");
        Map<String, String> parameter = inputAccountInfo();
        parameter.put("name", name);
        return parameter;
    }

    private String inputKeyword() {
        return IOUtils.input("지점명 또는 주소를 입력하세요: ");
    }

    private String inputEmployeeName() {
        return IOUtils.input("직원명을 입력하세요: ");
    }

    public static void displayStorage(List<AlbumStorageDTO> stock) {
        if(stock == null) {
            System.out.println("> 😅😅😅 조회된 재고가 없습니다. 😅😅😅");
        }
        else {
            System.out.println("-------------앨범별 재고목록-------------");
            for(AlbumStorageDTO storage : stock) {
                System.out.println(storage);
            }
            System.out.println("----------------------------");
        }
    }

    public static void displayOrder(List<OrderDTO> orders) {
        if(orders == null) {
            System.out.println("> 😅😅😅 조회된 주문이 없습니다. 😅😅😅");
        }
        else {
            System.out.println("-----------주문서-----------");
            for(OrderDTO order : orders) {
                System.out.println(order);
            }
            System.out.println("----------------------------");
        }
    }
}
