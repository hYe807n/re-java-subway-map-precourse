package subway.view;

import java.util.StringJoiner;
import subway.enums.Exceptions;
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
    }

    public static void printUploadStation() {
        System.out.println(Form.STATION_UPLOAD.getMessage());
    }

    public static void printRemoveStation() {
        System.out.println(Form.STATION_REMOVE.getMessage());
    }

    public static void printStations() {
        System.out.println(Form.STATIONS.getMessage());
    }

    public static void printInfo(String result) {
        System.out.println(new StringJoiner("", Form.SUCCESS.getMessage(),
            result));
    }
}
