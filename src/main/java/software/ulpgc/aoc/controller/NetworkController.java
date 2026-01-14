package software.ulpgc.aoc.controller;

import software.ulpgc.aoc.command.DirectPathCalculation;
import software.ulpgc.aoc.command.WaypointPathCalculation;
import software.ulpgc.aoc.model.ReactorNetwork;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NetworkController {

    // parsea el texto "nodo: vecino1 vecino2" al modelo
    private ReactorNetwork buildNetwork(List<String> lines) {
        Map<String, List<String>> map = lines.stream()
                .filter(line -> !line.trim().isEmpty())
                .map(line -> line.split(":"))
                .collect(Collectors.toMap(
                        parts -> parts[0].trim(),
                        parts -> Arrays.stream(parts[1].trim().split("\\s+"))
                                .collect(Collectors.toList())
                ));
        return new ReactorNetwork(map);
    }

    public long calculateSimpleRoute(List<String> data, String start, String end) {
        ReactorNetwork network = buildNetwork(data);
        return new DirectPathCalculation(start, end).execute(network);
    }

    public long calculateWaypointRoute(List<String> data, String start, String end, String w1, String w2) {
        ReactorNetwork network = buildNetwork(data);
        return new WaypointPathCalculation(start, end, w1, w2).execute(network);
    }
}