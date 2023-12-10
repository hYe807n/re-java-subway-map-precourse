package subway.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Section {

    private final Map<Line, List<Station>> section = new LinkedHashMap<>();

    public Section(Line line, List<Station> station) {
        this.section.put(line, station);
    }
}
