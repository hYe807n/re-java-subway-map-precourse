package subway.view;

import java.util.Scanner;

public class InputVIew {

    public static final Scanner read = new Scanner(System.in);

    public static String readMainOption() {
        OutputView.printMainScreen();
        OutputView.printSelect();
        return read.nextLine().trim();
    }

    public static String readStationOption() {
        OutputView.printStationScreen();
        OutputView.printSelect();
        return read.nextLine().trim();
    }

    public static String readStationUpload() {
        OutputView.printStationScreen();
        return read.nextLine().trim();
    }
}
