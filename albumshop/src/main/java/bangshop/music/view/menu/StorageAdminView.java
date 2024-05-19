package bangshop.music.view.menu;

import bangshop.music.common.utils.IOUtils;

import bangshop.music.controller.storageController;
import bangshop.music.model.dto.StockInDTO;
import bangshop.music.model.dto.stock.GetStockRequest;
import bangshop.music.model.dto.stock.InsertStockRequest;

import java.util.Scanner;
import bangshop.music.controller.DispatchController;


public class StorageAdminView {
    private final DispatchController dispatchController = new DispatchController();

    public void storageAdminMenu() {
        while (true) {
            displayMenu();
            String inputMenu = IOUtils.input("메뉴를 입력하세요: ");
            StorageAdminMenu menu = StorageAdminMenu.from(inputMenu);

            storageController storageController = new storageController();

            switch (menu) {
//                case STORAGE_STOCK ->//TODO: 앨범 재고 확인
//                case ORDERS ->//TODO: 주문 내역 조회
                case STOCK_IN ->  storageController.insertStock((InsertStockRequest) inStockAlbum()); //TODO 다빈: 앨범 입고
                case STOCK_IN_LIST -> storageController.getStockList(new StockInDTO()); //TODO 다빈: 앨범 입고 내역 조회
//                case STOCK_OUT_LIST ->//TODO: 앨범 출고 내역 조회
=======
//                case STOCK_IN ->//TODO: 앨범 입고
//                case STOCK_IN_LIST ->//TODO: 앨범 입고 내역 조회
//                case STOCK_OUT -> dispatchController.updateStockOut();
                case STOCK_OUT_LIST -> dispatchController.findStockOuts();
                case LOG_OUT -> {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        displayMenu();
    }

    private Object inStockAlbum() {

        Scanner sc = new Scanner(System.in);
        InsertStockRequest stock = null;
        try {
            System.out.print("입고할 앨범 코드를 입력하세요 : ");
            String albumNo = sc.nextLine();

            System.out.print("입고할 수량을 입력하세요 : ");
            int quantity = sc.nextInt();
            stock  =  new InsertStockRequest(albumNo, quantity);
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
            sc.nextLine();
        } finally {
            sc.close();
        }
        System.out.println("stock = " + stock.getAlbumNo());
        System.out.println("stock = " + stock.getQuantity());

        return stock;
    }

    private static void displayMenu() {
        System.out.println("==========창고관리자 메뉴==========");
        for (StorageAdminMenu menu : StorageAdminMenu.values()) {
            System.out.println(menu.getCode() + ". " + menu.getTitle());
        }
    }
}
