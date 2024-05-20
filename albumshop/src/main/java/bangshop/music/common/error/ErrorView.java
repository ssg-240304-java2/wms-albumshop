package bangshop.music.common.error;

public class ErrorView {
    public static void displayError(ErrorCode errorCode) {
        System.err.println(errorCode.getMsg());
    }
}
