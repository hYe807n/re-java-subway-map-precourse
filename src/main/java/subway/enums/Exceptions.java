package subway.enums;

public enum Exceptions {
    WRONG_OPTION("선택할 수 없는 기능입니다."),
    WRONG_NAME_LENGTH("이름은 두 글자 이상이어야 합니다."),
    NONE_UPLOAD_STATION("등록되지 않은 역입니다."),
    NONE_UPLOAD_LINE("등록되지 않은 노선입니다."),
    UPLOAD_REMOVE("노선에 등록된 역입니다."),
    MINIMUM_SECTION_SIZE("삭제할 구간의 노선에 포함된 역이 두 개 이하입니다."),
    WRONG_NAME_DUPLICATED("이름이 중복되었습니다.");

    private final String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
