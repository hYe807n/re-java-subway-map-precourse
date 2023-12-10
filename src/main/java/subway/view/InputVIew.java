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
        return read.nextLine().trim();
    }

    public static String readLineOptions() {
        OutputView.printLineScreen();
        return read.nextLine().trim();
    }

    public static String readStationUpload() {
        OutputView.printUploadStation();
        return read.nextLine().trim();
    }

    public static String readStationRemove() {
        OutputView.printRemoveStation();
        return read.nextLine().trim();
    }

    public static String readLineUpload() {
        OutputView.printUploadLine();
        return read.nextLine().trim();
    }

    public static String readLineStart() {
        OutputView.printLineStart();
        return read.nextLine().trim();
    }

    public static String readLineEnd() {
        OutputView.printLineEnd();
        return read.nextLine().trim();
    }

    public static String readSectionOption() {
        OutputView.printSectionScreen();
        OutputView.printSelect();
        return read.nextLine().trim();
    }

    public static String readSectionLine() {
        OutputView.printSectionLine();
        return read.nextLine().trim();
    }

    public static String readSectionStation() {
        OutputView.printSectionStation();
        return read.nextLine().trim();
    }

    public static String readSectionIndex() {
        OutputView.printSectionIndex();
        return read.nextLine().trim();
    }

    public static String readSectionRemoveLine() {
        OutputView.printSectionRemoveLine();
        return read.nextLine().trim();
    }

    public static String readSectionRemoveStation() {
        OutputView.printSectionRemoveStation();
        return read.nextLine().trim();
    }

    public static String readLineRemove() {
        OutputView.printLineRemove();
        return read.nextLine().trim();
    }
}
