package subway.enums;

public enum Form {
    MAIN_SCREEN("\n## 메인 화면\n"
        + "1. 역 관리\n"
        + "2. 노선 관리\n"
        + "3. 구간 관리\n"
        + "4. 지하철 노선도 출력\n"
        + "Q. 종료"),
    STATION_SCREEN("\n## 역 관리 화면\n"
        + "1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기"),
    SELECT("\n## 원하는 기능을 선택하세요."),
    STATIONS("\n## 역 목록"),
    STATION_REMOVE("\n## 삭제할 역 이름을 입력하세요."),
    STATION_UPLOAD("\n## 등록할 역 이름을 입력하세요."),
    LINE_UPLOAD("\n## 등록할 노선 이름을 입력하세요."),
    LINE_START("\n## 등록할 노선의 상행 종점역 이름을 입력하세요."),
    LINE_END("\n## 등록할 노선의 하행 종점역 이름을 입력하세요."),
    UPLOAD_STATION("지하철 역이 등록되었습니다."),
    UPLOAD_LINE("지하철 노선이 등록되었습니다."),
    REMOVE_STATION("지하철 역이 삭제되었습니다."),
    REMOVE_LINE("지하철 노선이 삭제되었습니다."),
    SUCCESS("\n[INFO] "),
    ERROR("\n[ERROR] ");

    private final String message;

    Form(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
