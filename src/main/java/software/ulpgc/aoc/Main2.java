package software.ulpgc.aoc;

import software.ulpgc.aoc.controller.NetworkController;
import software.ulpgc.aoc.io.FileInputReader;
import software.ulpgc.aoc.view.ConsoleVisualizer;

import java.nio.file.Path;

public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "you.txt");

    public static void main(String[] args) {
        try {
            // IO
            var data = new FileInputReader(INPUT_PATH).readLines();

            // CONTROLLER (Parte 2: you -> out pasando por 'dac' y 'fft')
            long result = new NetworkController().calculateWaypointRoute(data, "svr", "out", "dac", "fft");

            // VIEW
            new ConsoleVisualizer().show("Parte 2: ", result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}