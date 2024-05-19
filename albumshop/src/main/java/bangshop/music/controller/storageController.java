package bangshop.music.controller;

import bangshop.music.model.dto.StockInDTO;
import bangshop.music.model.dto.stock.GetStockRequest;
import bangshop.music.model.dto.stock.InsertStockRequest;
import bangshop.music.model.service.storageService;
import bangshop.music.view.PrintsResult;

import java.util.List;

public class storageController {

    private final storageService service;
    private final PrintsResult printsResult;

    public storageController() {
        service = new storageService();
        printsResult = new PrintsResult();
    }

    //입고처리
    public void insertStock(InsertStockRequest request) {
        service.insertStock(request);
    }

    // 입고내역 조회
    public List<StockInDTO> getStockList(GetStockRequest request) {
        return service.getStockList(request);
    }

    public void findStoreStorage() {
    }
}
