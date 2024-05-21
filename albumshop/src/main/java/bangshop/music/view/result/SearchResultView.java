package bangshop.music.view.result;

import bangshop.music.common.utils.IOUtils;
import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.service.OrderService;

import java.util.List;

public class SearchResultView {

    public static void displayAlbumList(List<AlbumDTO> albumList, int employeeNo) {
        if (albumList == null || albumList.isEmpty()) {
            System.out.println("검색 결과가 존재하지 않습니다.");
        } else {
            System.out.println("-".repeat(100));
            System.out.println("번호\t앨범번호\t가수\t앨범이름\t발매일\t가격");
            System.out.println("-".repeat(100));
            for (int i = 0; i < albumList.size(); i++) {
                AlbumDTO album = albumList.get(i);
                System.out.println(
                        (i + 1) + ". " + album.getAlbumNo() + "\t" + album.getSinger() + "\t" + album.getAlbumName()
                                + "\t"
                                + album.getReleaseDate() + "\t" + album.getPrice());
            }
            System.out.println();
            while (true) {

            String input = IOUtils.input("주문하려면 번호를 입력하시고\n메인메뉴로 돌아가려면 Q를 입력하세요: ");

            if (input.matches("[0-9]+")) {

                OrderService orderService = new OrderService();

                int quantity = Integer.parseInt(IOUtils.input("수량을 입력해주세요: "));
                String albumNo = albumList.get(Integer.parseInt(input)).getAlbumNo();
                int result = orderService.order(albumNo, quantity, employeeNo);
            } else {
                if (input.toLowerCase().equals("q")) {
                    break;
                } else {
                    System.out.println("잘못된 값을 입력하셨습니다.\n");
                }
            }
            }
        }
    }
}
