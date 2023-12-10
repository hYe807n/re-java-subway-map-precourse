package subway.enums;

public enum SectionOptions {
    UPLOAD("1"),
    REMOVE("2"),
    EXIT("B");


    private final String option;

    SectionOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
