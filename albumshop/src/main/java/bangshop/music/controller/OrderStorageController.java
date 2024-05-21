package bangshop.music.controller;

import bangshop.music.common.error.ErrorCode;
import bangshop.music.common.error.ErrorView;
import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.dto.OrderDTO;
import bangshop.music.model.service.OrderStorageService;
import bangshop.music.view.menu.StorageAdminView;
import bangshop.music.view.menu.StoreManagerView;

import java.util.List;
import java.util.Map;

public class OrderStorageController {

    private static OrderStorageService orderStorageService = new OrderStorageService();

    public static void findOrder() {
        try {
            List<OrderDTO> order = OrderStorageService.findOrder();
            StorageAdminView.displayOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.STOCK_ERROR);
        }
    }
    public static void getStorageStock(int number) {
        try {
            List<AlbumStorageDTO> storage = OrderStorageService.getStorageStock(number);
            StorageAdminView.displayStorage(storage);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.STOCK_ERROR);
        }
    }
    public static void getStoreStock(int number){
        try {
            List<AlbumStorageDTO> storage = OrderStorageService.getStoreStock(number);
            StoreManagerView.displayStorage(storage);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.STOCK_ERROR);
        }
    }

}
