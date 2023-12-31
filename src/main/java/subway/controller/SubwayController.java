package subway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import subway.Validator.Exception;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Sections;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.enums.Form;
import subway.enums.LineOptions;
import subway.enums.MainOptions;
import subway.enums.SectionOptions;
import subway.enums.StationOptions;
import subway.view.InputVIew;
import subway.view.OutputView;

public class SubwayController {


    public void run() {
        initializeInforms();
        String option;
        do {
            option = mainScreen();
            manageState(option);
        } while (!option.equals(MainOptions.EXIT.getOption()));
    }

    private void manageState(String option) {
        if (option.equals(MainOptions.STATION.getOption())) {
            stationScreen();
        }
        if (option.equals(MainOptions.LINE.getOption())) {
            lineScreen();
        }
        if (option.equals(MainOptions.SECTION.getOption())) {
            sectionScreen();
        }
        if (option.equals(MainOptions.SUBWAY_LINES.getOption())) {
            showAllLines();
        }
    }

    private void sectionScreen() {
        String option = chooseSectionOption();
        if (option.equals(SectionOptions.EXIT.getOption())) {
            return;
        }
        if (option.equals(SectionOptions.UPLOAD.getOption())) {
            OutputView.printInfoResult(uploadSection());
        }
        if (option.equals(SectionOptions.REMOVE.getOption())) {
            OutputView.printInfoResult(removeSection());
        }
    }

    private String removeSection() {
        Line line = LineRepository.findLine(InputVIew.readSectionRemoveLine());
        Station station = StationRepository.findStation(InputVIew.readSectionRemoveStation());
        Sections.deleteSection(line, station);
        return Form.REMOVE_SECTION.getMessage();
    }

    private String uploadSection() {
        Line line = LineRepository.findLine(InputVIew.readSectionLine());
        Station station = StationRepository.findStation(InputVIew.readSectionStation());
        int index = Integer.parseInt(InputVIew.readSectionIndex());
        Sections.addByIndex(line, station, index);
        return Form.UPLOAD_SECTION.getMessage();
    }

    private String chooseSectionOption() {
        String option;
        try {
            option = InputVIew.readSectionOption();
            Exception.validateSectionOption(option);
            return option;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            option = chooseSectionOption();
        }
        return option;
    }

    private void showAllLines() {
        OutputView.printShowInfo(Form.ALL_LINES.getMessage());
        Sections.sections().keySet()
            .forEach(line -> {
                OutputView.printInfo(line.getName());
                OutputView.printInfo(Form.DIVISION.getMessage());
                Sections.findStationsByLine(line).forEach(station ->
                    OutputView.printInfo(station.getName()));
                OutputView.printEmpty();
            });
    }

    private void lineScreen() {
        String option = chooseLineOption();
        if (option.equals(LineOptions.EXIT.getOption())) {
            return;
        }
        if (option.equals(LineOptions.UPLOAD.getOption())) {
            OutputView.printInfoResult(uploadLine());
        }
        if (option.equals(LineOptions.REMOVE.getOption())) {
            OutputView.printInfoResult(removeLine());
        }
        if (option.equals(LineOptions.SHOW.getOption())) {
            showLines();
        }
    }

    private String chooseLineOption() {
        String option;
        try {
            option = InputVIew.readLineOptions();
            Exception.validateOption(option);
            return option;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            option = chooseLineOption();
        }
        return option;
    }

    private String uploadLine() {
        try {
            Line line = new Line(InputVIew.readLineUpload());
            LineRepository.addLine(line);
            Sections.addSection(line,
                Arrays.asList(StationRepository.findStation(InputVIew.readLineStart()),
                StationRepository.findStation(InputVIew.readLineEnd())));
            return Form.UPLOAD_LINE.getMessage();
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            return uploadLine();
        }
    }

    private String removeLine() {
        try {
            LineRepository.deleteLine(InputVIew.readLineRemove());
            return Form.REMOVE_LINE.getMessage();
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            removeStation();
        }
        return removeStation();
    }

    private void showLines() {
        OutputView.printShowInfo(Form.LINES.getMessage());
        LineRepository.lines()
            .forEach(station -> OutputView.printInfo(station.getName()));
        OutputView.printEmpty();
    }

    private void stationScreen() {
        String option = chooseStationOption();
        if (option.equals(StationOptions.EXIT.getOption())) {
            return;
        }
        if (option.equals(StationOptions.UPLOAD.getOption())) {
            OutputView.printInfoResult(uploadStation());
        }
        if (option.equals(StationOptions.REMOVE.getOption())) {
            OutputView.printInfoResult(removeStation());
        }
        if (option.equals(StationOptions.SHOW.getOption())) {
            showStations();
        }
    }

    private void showStations() {
        OutputView.printShowInfo(Form.STATIONS.getMessage());
        StationRepository.stations()
            .forEach(station -> OutputView.printInfo(station.getName()));
        OutputView.printEmpty();
    }

    private String removeStation() {
        try {
            StationRepository.deleteStation(InputVIew.readStationRemove());
            return Form.REMOVE_STATION.getMessage();
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            removeStation();
        }
        return removeStation();
    }

    private String uploadStation() {
        try {
            StationRepository.addStation(new Station(InputVIew.readStationUpload()));
            return Form.UPLOAD_STATION.getMessage();
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            return uploadStation();
        }
    }

    private String chooseStationOption() {
        String option;
        try {
            option = InputVIew.readStationOption();
            Exception.validateOption(option);
            return option;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            option = chooseStationOption();
        }
        return option;
    }

    private String mainScreen() {
        String option;
        try {
            option = InputVIew.readMainOption();
            Exception.validateMainOption(option);
            return option;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
            option = mainScreen();
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
        Sections.addSection(LineRepository.findLine(line), station);
    }

    private void initializeLines() {
        List<Line> linesInitial = new ArrayList<>(Arrays
            .asList(new Line("2호선"), new Line("3호선"), new Line("신분당선")));
        linesInitial.forEach(LineRepository::addLine);
    }

    private void initializeStations() {
        List<Station> stationsInitial = new ArrayList<>(Arrays
            .asList(new Station("교대역"), new Station("강남역"), new Station("역삼역")
                , new Station("남부터미널역"), new Station("양재역")
                , new Station("양재시민의숲역"), new Station("매봉역")));
        stationsInitial.forEach(StationRepository::addStation);
    }
}
