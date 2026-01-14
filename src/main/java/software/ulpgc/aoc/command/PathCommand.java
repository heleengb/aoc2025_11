package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.ReactorNetwork;

public interface PathCommand {
    long execute(ReactorNetwork network);
}