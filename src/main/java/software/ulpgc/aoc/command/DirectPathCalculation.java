package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.ReactorNetwork;

// Parte 1: Inicio -> Fin
public record DirectPathCalculation(String start, String end) implements PathCommand {
    @Override
    public long execute(ReactorNetwork network) {
        return network.countRoutes(start, end);
    }
}