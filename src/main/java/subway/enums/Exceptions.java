package subway.enums;

public enum Exceptions {
    WRONG_OPTION("선택할 수 없는 기능입니다."),
    WRONG_NAME_LENGTH("이름은 두 글자 이상이어야 합니다."),
    WRONG_NAME_DUPLICATED("이름이 중복되었습니다.");

    private final String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
