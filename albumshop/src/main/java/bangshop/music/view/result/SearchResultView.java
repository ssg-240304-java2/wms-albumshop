package bangshop.music.view.result;

import bangshop.music.common.utils.IOUtils;
import bangshop.music.model.dto.AlbumDTO;
import bangshop.music.model.service.OrderService;
import java.text.*;
import java.util.*;

public class SearchResultView {

    public static void displayAlbumList(List<AlbumDTO> albumList, int employeeNo) {

        if (albumList == null || albumList.isEmpty()) {
            System.out.println("검색 결과가 존재하지 않습니다.");
        } else {

            displayAlbumRows(albumList);
            System.out.println();

            while (true) {

                String input = IOUtils.input("주문하려면 번호를\n정렬하려면 S를\n메인메뉴로 돌아가려면 Q를 입력하세요: ");

                if (input.matches("[0-9]+")) {

                    OrderService orderService = new OrderService();

                    int quantity = Integer.parseInt(IOUtils.input("수량을 입력해주세요: "));
                    String albumNo = albumList.get(Integer.parseInt(input) - 1).getAlbumNo();
                    int result = orderService.order(albumNo, quantity, employeeNo);
                    if (result > 0) {
                        System.out.println("주문에 성공했습니다.");
                    } else {
                        System.out.println("주문 실패!");
                    }
                    break;
                } else {
                    if (input.toLowerCase().equals("q")) {
                        break;
                    }
                    if (input.toLowerCase().equals("s")) {
                        sortList(albumList);
                        displayAlbumRows(albumList);
                    } else {
                        System.out.println("잘못된 값을 입력하셨습니다.\n");
                    }
                }
            }
        }
    }

    public void displayAllAlbum(List<AlbumDTO> albumList) {
        sortList(albumList);
        displayAlbumRows(albumList);
    }


    public static void displayAlbumRows(List<AlbumDTO> albumList) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("-".repeat(140));
        System.out.printf("%-5s %-15s %-16s %-10s %-20s %-60s%n", "번호", "앨범번호", "발매일", "가격", "가수", "앨범이름");
        System.out.println("-".repeat(140));

        for (int i = 0; i < albumList.size(); i++) {
            AlbumDTO album = albumList.get(i);
            System.out.printf("%-7s %-17s %-18s %-12s %-22s %-60s%n", (i + 1), album.getAlbumNo(),
                    dateFormat.format(album.getReleaseDate()), +album.getPrice(),
                    album.getSinger(),
                    "\b".repeat(countHangul(album.getSinger())) + album.getAlbumName());
        }
    }
    public static int countHangul(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); ) {
            int codePoint = str.codePointAt(i);
            if (isHangulCodePoint(codePoint)) {
                count++;
            }
            i += Character.charCount(codePoint);
        }
        return count;
    }


    private static boolean isHangulCodePoint(int codePoint) {
        return (0xAC00 <= codePoint && codePoint <= 0xD7A3);
    }

    private static void sortList(List<AlbumDTO> albumList) {
        String sort = IOUtils.input(
                """
                        \n1. 가수순으로 보기
                        2. 앨범 제목순으로 보기
                        3. 발매일순으로 보기
                        4. 가격순으로 보기
                        정렬 방법을 선택해주세요: """);
        switch (sort) {
            case "1" -> albumList.sort((m1, m2) -> m1.getSinger().compareTo(m2.getSinger()));
            case "2" -> albumList.sort((m1, m2) -> m1.getAlbumName().compareTo(m2.getAlbumName()));
            case "3" -> albumList.sort((m1, m2) -> m1.getReleaseDate().compareTo(m2.getReleaseDate()));
            case "4" -> albumList.sort((m1, m2) -> Integer.compare(m1.getPrice(), m2.getPrice()));
        }
    }
}