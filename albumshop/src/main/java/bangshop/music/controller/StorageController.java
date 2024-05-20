package bangshop.music.controller;

import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.dto.StockInDTO;
import bangshop.music.model.dto.stock.InsertStockRequest;
import bangshop.music.model.service.StorageService;
import bangshop.music.view.PrintsResult;

import java.util.List;

public class StorageController {

    private final StorageService service;
    private final PrintsResult printsResult;

    public StorageController() {
        service = new StorageService();
        printsResult = new PrintsResult();
    }

    public void insertStock(InsertStockRequest request) {
        service.insertStock(request);
    }

    // 입고내역 조회
    public List<StockInDTO> getStockList(StockInDTO request) {
        return service.getStockList(request);
    }

    public void insertAlbum(AlbumDTO request) {
        service.insertAlbum(request);
    }
}
