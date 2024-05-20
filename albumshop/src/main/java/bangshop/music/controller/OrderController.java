package bangshop.music.controller;

import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.service.OrderService;
import bangshop.music.model.service.SearchService;
import bangshop.music.view.result.SearchResultView;

import java.util.List;
import java.util.Scanner;

public class OrderController {
    Scanner sc = new Scanner(System.in);
    SearchService searchService = new SearchService();
        OrderService orderService = new OrderService();


    public void order(String albumNo, int quantity) {

        // emp_no로 store_no
        orderService.order(albumNo, quantity /*empNo*/);

    }
}
