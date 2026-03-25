import java.util.*;

public class HomeVisitShortestPathPage {

    private static final Map<String, Map<String, Integer>> graph = new HashMap<>();

    static {
        addEdge("Hospital", "AreaA", 5);
        addEdge("Hospital", "AreaB", 10);
        addEdge("AreaA", "AreaC", 4);
        addEdge("AreaB", "AreaC", 2);
    }

    private static void addEdge(String a, String b, int w) {
        graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, w);
        graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, w);
    }

    public static void findShortestPath(String start, String end) {

        Map<String, Integer> dist = new HashMap<>();
        PriorityQueue<String> pq =
            new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String node : graph.keySet())
            dist.put(node, Integer.MAX_VALUE);

        dist.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();

            for (var n : graph.get(current).entrySet()) {
                int newDist = dist.get(current) + n.getValue();
                if (newDist < dist.get(n.getKey())) {
                    dist.put(n.getKey(), newDist);
                    pq.add(n.getKey());
                }
            }
        }

        System.out.println("Shortest distance from " + start +
                " to " + end + " = " + dist.get(end));
    }
}
