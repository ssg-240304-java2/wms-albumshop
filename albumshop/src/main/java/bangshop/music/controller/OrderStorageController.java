package bangshop.music.controller;

import bangshop.music.common.error.ErrorCode;
import bangshop.music.common.error.ErrorView;
import bangshop.music.model.dto.AlbumStorageDTO;
import bangshop.music.model.dto.OrderDTO;
import bangshop.music.model.service.OrderStorageService;
import bangshop.music.view.menu.StorageAdminView;
import bangshop.music.view.menu.StoreManagerView;

import java.util.List;

public class OrderStorageController {

    private OrderStorageService orderStorageService = new OrderStorageService();

    public static void findStoreStorage(String number) {
        try {
            List<AlbumStorageDTO> storage = OrderStorageService.findStoreStorage(number);
            StorageAdminView.displayStorage(storage);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.STOCK_ERROR);
        }
    }

    public OrderStorageController() {
        orderStorageService = new OrderStorageService();
    }

    public static void findOrder() {
        try {
            List<OrderDTO> order = OrderStorageService.findOrder();
            StorageAdminView.displayOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.STOCK_ERROR);
        }
    }
    public static void findStorageStock(String number) {
        try {
            List<AlbumStorageDTO> storage = OrderStorageService.findStorageStock(number);
            StorageAdminView.displayStorage(storage);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.STOCK_ERROR);
        }
    }
}
