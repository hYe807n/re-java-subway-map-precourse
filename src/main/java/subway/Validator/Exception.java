package subway.Validator;

import java.util.Arrays;
import subway.enums.Exceptions;
import subway.enums.MainOptions;
import subway.enums.StationOptions;

public class Exception {

    private static final int MINIMUM_LENGTH = 2;


    public static void validateMainOption(String option) {
        if (Arrays.stream(MainOptions.values()).anyMatch(
            number -> number.getOption().equals(option))
        || validateInputNull(option)) {
            return;
        }
        throw new IllegalArgumentException(Exceptions.WRONG_OPTION.getMessage());
    }

    public static boolean validateInputNull(String option) {
        return option == null;
    }

    public static void validateStationOption(String option) {
        if (Arrays.stream(StationOptions.values()).anyMatch(
            number -> number.getOption().equals(option))
            || validateInputNull(option)) {
            return;
        }
        throw new IllegalArgumentException(Exceptions.WRONG_OPTION.getMessage());
    }

    public static void validateNameLength(String name) {
        if (name.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException(Exceptions.WRONG_NAME_LENGTH.getMessage());
        }
    }
}
