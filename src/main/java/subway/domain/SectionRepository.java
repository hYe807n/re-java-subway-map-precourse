package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return sections;
    }

    public static void addSection(Section section) {
        sections.add(section);
    }
}
