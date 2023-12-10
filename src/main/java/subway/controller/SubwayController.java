package subway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayController {

    public void run() {
        initializeInforms();
    }

    private void initializeInforms() {
        initializeLines();
        initializeStations();
        initializeSections("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        initializeSections("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        initializeSections("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));
    }

    private void initializeSections(String line, List<String> stations) {
        List<Station> station = stations.stream().map(
            StationRepository::findStation
        ).collect(Collectors.toList());
        SectionRepository.addSection(new Section(LineRepository.findLine(line), station));
    }

    private void initializeLines() {
        List<Line> linesInitial = new ArrayList<>(Arrays
            .asList(new Line("2호선"), new Line("3호선"), new Line("신분당선")));
        linesInitial.forEach(LineRepository::addLine);
    }

    private void initializeStations() {
        List<Station> stationsInitial = new ArrayList<>(Arrays
            .asList(new Station("교대역"), new Station("강남역"), new Station("역삼역")
                , new Station("남부터미널역"), new Station("양재역"), new Station("매봉역")
                , new Station("양재시민의숲역")));
        stationsInitial.forEach(StationRepository::addStation);
    }
}
