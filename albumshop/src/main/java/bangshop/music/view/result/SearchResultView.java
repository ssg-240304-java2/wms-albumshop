package bangshop.music.view.result;

import bangshop.music.model.dto.AlbumDTO;
import java.util.List;

public class SearchResultView {

    public static void displayAlbumList(List<AlbumDTO> albumList) {
        if (albumList == null || albumList.isEmpty()) {
            System.out.println("검색 결과가 존재하지 않습니다.");
        } else {
            System.out.println("-".repeat(20));
            for (AlbumDTO album : albumList) {

            }
        }
    }
}
