package software.ulpgc.aoc.view;

public class ConsoleVisualizer implements ResultVisualizer {
    @Override
    public void show(String title, long count) {
        System.out.println(title);
        System.out.println("Total Caminos: " + count);
    }
}