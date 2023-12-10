package subway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import subway.Validator.Exception;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.enums.MainOptions;
import subway.enums.StationOptions;
import subway.view.InputVIew;
import subway.view.OutputView;

public class SubwayController {


    public void run() {
        initializeInforms();
        String option;
        do {
            option = mainScreen();
        } while (!option.equals(MainOptions.EXIT.getOption()));
    }

    private void manageState(String option) {
        if (option.equals(MainOptions.STATION.getOption())) {
            stationScreen();
        }
    }

    private void stationScreen() {
        String option = chooseStationOption();
        if (option.equals(StationOptions.UPLOAD.getOption())) {
            uploadStation();
        }
    }

    private void uploadStation() {
        try {
            StationRepository.addStation(new Station(InputVIew.readStationUpload()));
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            uploadStation();
        }

    }

    private String chooseStationOption() {
        String option = null;
        try {
            option = InputVIew.readStationOption();
            Exception.validateStationOption(option);
            return option;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            option = mainScreen();
        }
        return option;
    }

    private String mainScreen() {
        String option = null;
        try {
            option = InputVIew.readMainOption();
            Exception.validateMainOption(option);
            return option;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            mainScreen();
        }
        return option;
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
