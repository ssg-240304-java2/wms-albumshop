package bangshop.music.view.result;

import bangshop.music.model.dto.AlbumDTO;
import java.util.List;

public class SearchResultView {

    public static void displayAlbumList(List<AlbumDTO> albumList) {
        if (albumList == null || albumList.isEmpty()) {
            System.out.println("검색 결과가 존재하지 않습니다.");
        } else {
            System.out.println("-".repeat(100));
            System.out.println("번호\t앨범번호\t가수\t앨범이름\t발매일\t가격");
            System.out.println("-".repeat(100));
            for (int i = 0; i < albumList.size(); i++) {
                AlbumDTO album = albumList.get(i);
//todo: null | len(0) -> 에러출력
                System.out.println(
                        (i + 1) + ". " + album.getAlbumNo() + "\t" + album.getSinger() + "\t" + album.getAlbumName()
                                + "\t"
                                + album.getReleaseDate() + "\t" + album.getPrice()+"\n\n");
            }
        }
    }
}
