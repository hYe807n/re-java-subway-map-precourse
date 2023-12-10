package subway.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import subway.enums.Exceptions;

public class Sections {
    private static final Map<Line, List<Station>> sections = new LinkedHashMap<>();

    public static Map<Line, List<Station>> sections() {
        return sections;
    }

    public static void addSection(Line line, List<Station> section) {
        sections.put(line, section);
    }

    public static boolean isUploadLine(String name) {
        return sections.keySet().stream()
            .anyMatch(line -> sections().get(line).stream()
                .anyMatch(station -> station.getName().equals(name)));
    }

    public static List<Station> findStationsByLine(Line line) {
        return sections.get(line);
    }

    public static void addByIndex(Line line, Station station, int index) {
        sections.get(line).add(index - 1, station);
    }

    public static void deleteSection(Line line, Station station) {
        if (sections.get(line).size() <= 2 ) {
            throw new IllegalArgumentException(Exceptions.MINIMUM_SECTION_SIZE.getMessage());
        }

    }
}
