package subway.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Sections {
    private static final Map<Line, List<Station>> sections = new LinkedHashMap<>();

    public static Map<Line, List<Station>> sections() {
        return sections;
    }

    public static void addSection(Line line, List<Station> section) {
        sections.put(line, section);
    }

    public static boolean isUploadLine(String name) {
        return sections().keySet().stream()
            .anyMatch(line -> sections().get(line).stream()
                .anyMatch(station -> station.getName().equals(name)));
    }
}
