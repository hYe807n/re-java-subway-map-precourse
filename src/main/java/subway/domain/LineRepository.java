package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.enums.Exceptions;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static Line findLine(String name) {
        return lines().stream().filter(line -> line.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(Exceptions.NONE_UPLOAD_LINE.getMessage()));
    }

    public static void deleteLine(String name) {
        lines().remove(findLine(name));
    }

    public static boolean isDuplicated(String name) {
        return lines.stream()
            .anyMatch(line -> line.getName().equals(name));
    }
}
