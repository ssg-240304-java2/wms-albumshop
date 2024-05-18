package bangshop.music.common.utils;

import java.util.Scanner;

/**
 * 입출력 도구
 */
public class IOUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * <pre>{@code
     * String menu = IOUtils.input("메뉴를 입력해 주세요: ");
     * }</pre>
     *
     * @param text 입력할 때 필요한 문구
     * @return 입력한 값
     */
    public static String input(String text) {
        System.out.print(text);
        return SCANNER.nextLine();
    }
}
