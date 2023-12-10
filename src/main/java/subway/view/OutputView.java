package subway.view;

import java.util.StringJoiner;
import org.omg.CORBA.PUBLIC_MEMBER;
import subway.enums.Form;

public class OutputView {

    public static void printMainScreen() {
        System.out.println(Form.MAIN_SCREEN.getMessage());
    }

    public static void printException(String message) {
        System.out.println(new StringJoiner("", Form.ERROR.getMessage(), message));
    }
}
