package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.enums.Exceptions;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static Station findStation(String name) {
        return stations().stream().filter(station -> station.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(Exceptions.NONE_UPLOAD_STATION.getMessage()));
    }

    public static boolean isDuplicated(String name) {
        return stations().stream()
            .anyMatch(station -> station.getName().equals(name));
    }

    public static void deleteStation(String name) {
        if (Sections.isUploadLine(name)) {
            throw new IllegalArgumentException(Exceptions.UPLOAD_REMOVE.getMessage());
        }
        stations.remove(findStation(name));
    }
}
