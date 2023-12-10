package subway.enums;

public enum MainOptions {
    STATION("1"),
    LINE("2"),
    SECTION("3"),
    SUBWAY_LINES("4"),
    EXIT("Q");


    private final String option;

    MainOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
