package bangshop.music.controller;

import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.service.SearchService;
import java.util.List;
import java.util.Scanner;

public class SearchController {
    SearchService searchService = new SearchService();



    public void searchAlbumByTitle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("앨범 제목을 입력하세요: ");

        List<AlbumDTO> albumList = searchService.searchAlbumByTitle(sc.nextLine());

        System.out.println("-".repeat(100));
        System.out.println("번호\t앨범번호\t가수\t앨범이름\t발매일\t가격");
        System.out.println("-".repeat(100));
        for (int i = 0; i < albumList.size(); i++) {
            AlbumDTO album = albumList.get(i);
//todo: null | len(0) -> 에러출력
            System.out.println((i+1)+". "+album.getAlbumNo()+"\t"+album.getSinger()+"\t"+album.getAlbumName()+"\t"
                    +album.getReleaseDate()+"\t"+album.getPrice());
        }
    }
}
