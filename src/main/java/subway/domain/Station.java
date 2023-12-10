package subway.domain;

import subway.enums.Exceptions;

public class Station {

    private static final int MINIMUM_LENGTH = 2;

    private final String name;

    public Station(String name) {
        validate(name);
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException(Exceptions.WRONG_NAME_LENGTH.getMessage());
        }
        if (StationRepository.isDuplicated(name)) {
            throw new IllegalArgumentException(Exceptions.WRONG_NAME_DUPLICATED.getMessage());
        }
    }
}
