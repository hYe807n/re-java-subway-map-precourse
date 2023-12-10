package subway.enums;

public enum LineOptions {
    UPLOAD("1"),
    REMOVE("2"),
    SHOW("3"),
    EXIT("B");


    private final String option;

    LineOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
