package subway.view;

import java.util.StringJoiner;
import subway.enums.Form;

public class OutputView {

    public static void printMainScreen() {
        System.out.println(Form.MAIN_SCREEN.getMessage());
    }

    public static void printException(String message) {
        System.out.println(new StringJoiner("", Form.ERROR.getMessage(), message));
    }

    public static void printSelect() {
        System.out.println(Form.SELECT.getMessage());
    }

    public static void printStationScreen() {
        System.out.println(Form.STATION_SCREEN.getMessage());
        printSelect();
    }

    public static void printLineScreen() {
        System.out.println(Form.LINE_SCREEN.getMessage());
        printSelect();
    }

    public static void printUploadStation() {
        System.out.println(Form.STATION_UPLOAD.getMessage());
    }

    public static void printRemoveStation() {
        System.out.println(Form.STATION_REMOVE.getMessage());
    }

    public static void printShowInfo(String info) {
        System.out.print(info);
    }
    public static void printInfo(String info) {
        System.out.print(new StringJoiner("", Form.SUCCESS.getMessage(), info));
    }

    public static void printInfoResult(String result) {
        System.out.println(new StringJoiner("", Form.SUCCESS.getMessage(),
            result));
    }

    public static void printUploadLine() {
        System.out.println(Form.LINE_UPLOAD.getMessage());
    }

    public static void printLineStart() {
        System.out.println(Form.LINE_START.getMessage());
    }

    public static void printLineEnd() {
        System.out.println(Form.LINE_END.getMessage());
    }

    public static void printEmpty() {
        System.out.println("");
    }

    public static void printSectionScreen() {
        System.out.println(Form.SECTION_SCREEN.getMessage());
    }
    public static void printSectionLine() {
        System.out.println(Form.SECTION_LINE.getMessage());
    }
    public static void printSectionStation() {
        System.out.println(Form.SECTION_STATION.getMessage());
    }
    public static void printSectionIndex() {
        System.out.println(Form.SECTION_INDEX.getMessage());
    }
    public static void printSectionRemoveLine() {
        System.out.println(Form.SECTION_REMOVE_LINE.getMessage());
    }

    public static void printSectionRemoveStation() {
        System.out.println(Form.SECTION_REMOVE_STATION.getMessage());
    }
}
