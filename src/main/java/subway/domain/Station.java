package subway.domain;

import subway.Validator.Exception;
import subway.enums.Exceptions;

public class Station {

    private final String name;

    public Station(String name) {
        validate(name);
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        Exception.validateNameLength(name);
        if (StationRepository.isDuplicated(name)) {
            throw new IllegalArgumentException(Exceptions.WRONG_NAME_DUPLICATED.getMessage());
        }
    }
}
