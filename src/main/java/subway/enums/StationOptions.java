package subway.enums;

public enum StationOptions {
    UPLOAD("1"),
    REMOVE("2"),
    SHOW("3"),
    EXIT("B");


    private final String option;

    StationOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
