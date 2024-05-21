package bangshop.music.controller;

import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.service.SearchService;
import bangshop.music.view.result.SearchResultView;
import java.util.List;
import java.util.Scanner;

public class SearchController {
    Scanner sc = new Scanner(System.in);
    SearchService searchService = new SearchService();
    SearchResultView searchResultView = new SearchResultView();


    public void searchAlbumByTitle(int employeeNo) {
        System.out.print("앨범 제목을 입력하세요: ");

        List<AlbumDTO> albumList = searchService.searchAlbumByTitle(sc.nextLine());
        searchResultView.displayAlbumList(albumList, employeeNo);
//        System.out.println("-".repeat(100));
//        System.out.println("번호\t앨범번호\t가수\t앨범이름\t발매일\t가격");
//        System.out.println("-".repeat(100));
//        for (int i = 0; i < albumList.size(); i++) {
//            AlbumDTO album = albumList.get(i);
    }

    public void searchAlbumBySinger(int employeeNo) {
        System.out.print("가수를 입력하세요: ");

        List<AlbumDTO> albumList = searchService.searchAlbumBySinger(sc.nextLine());
        searchResultView.displayAlbumList(albumList, employeeNo);

    }

    public void searchAlbumByNo(int employeeNo) {
        System.out.print("앨범 번호를 입력하세요: ");

        List<AlbumDTO> albumList = searchService.searchAlbumByNo(sc.nextLine());
        searchResultView.displayAlbumList(albumList, employeeNo);
    }
}
