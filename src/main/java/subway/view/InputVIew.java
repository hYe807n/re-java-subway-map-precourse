package subway.view;

import java.util.Scanner;

public class InputVIew {

    public static final Scanner read = new Scanner(System.in);

    public static String readMainOption() {
        OutputView.printMainScreen();
        return read.nextLine().trim();
    }
}
