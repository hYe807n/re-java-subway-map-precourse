package subway.Validator;

import java.util.Arrays;
import subway.enums.MainOptions;

public class Exception {

    public static void validateMainOption(String option) {
        if (Arrays.stream(MainOptions.values()).anyMatch(
            number -> number.getOption().equals(option))
        || validateInputNull(option)) {
            return;
        }
        throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
    }

    public static boolean validateInputNull(String option) {
        return option == null;
    }
}
