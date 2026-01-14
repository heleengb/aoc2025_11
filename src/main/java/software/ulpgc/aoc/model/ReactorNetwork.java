package software.ulpgc.aoc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReactorNetwork {
    private final Map<String, List<String>> connections;

    public ReactorNetwork(Map<String, List<String>> connections) {
        this.connections = connections;
    }

    // Calcula caminos de A a B usando memoization
    public long countRoutes(String start, String end) {
        Map<String, Long> cache = new HashMap<>();
        return dfs(start, end, cache);
    }

    private long dfs(String current, String target, Map<String, Long> memo) {
        if (current.equals(target)) return 1;
        if (memo.containsKey(current)) return memo.get(current);

        long paths = 0;
        List<String> neighbors = connections.get(current);

        if (neighbors != null) {
            for (String neighbor : neighbors) {
                paths += dfs(neighbor, target, memo);
            }
        }

        memo.put(current, paths);
        return paths;
    }

    public int size() {
        return connections.size();
    }
}