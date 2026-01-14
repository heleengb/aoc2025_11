package software.ulpgc.aoc;

import software.ulpgc.aoc.controller.NetworkController;
import software.ulpgc.aoc.io.FileInputReader;
import software.ulpgc.aoc.view.ConsoleVisualizer;

import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "you.txt");

    public static void main(String[] args) {
        try {
            // IO
            var data = new FileInputReader(INPUT_PATH).readLines();

            // CONTROLLER (Parte 1: you -> out)
            long result = new NetworkController().calculateSimpleRoute(data, "you", "out");

            // VIEW
            new ConsoleVisualizer().show("Parte 1: ", result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}