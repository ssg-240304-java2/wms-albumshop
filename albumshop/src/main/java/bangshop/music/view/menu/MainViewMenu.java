package bangshop.music.view.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum MainViewMenu {
    SIGN_IN("1", "로그인"),
    SIGN_UP("2", "회원가입"),
    EXIT("3", "프로그램 종료");

    private final String code;
    private final String title;

    public static MainViewMenu from(String code) {
        return Arrays.stream(MainViewMenu.values())
                .filter(it -> it.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("메뉴를 다시 확인해주세요."));
    }
}
