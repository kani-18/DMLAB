import java.util.*;

public class Main14 {
    public static void addData(Map<String, Map<String, Map<String, Integer>>> cube, String time, String item,
            String location, int value) {
        cube.computeIfAbsent(time, k -> new HashMap<>()).computeIfAbsent(item, k -> new HashMap<>()).put(location,
                value);

    };

    public static void main(String[] args) {
        Map<String, Map<String, Map<String, Integer>>> cube = new HashMap<>();
        addData(cube, "Q1", "Laptop", "Delhi", 100);
        addData(cube, "Q1", "Laptop", "Mumbai", 150);
        addData(cube, "Q1", "Phone", "Delhi", 200);
        addData(cube, "Q1", "Phone", "Mumbai", 180);

        // rolling up on location
        Map<String, Map<String, Integer>> rollup = new HashMap<>();
        for (String time : cube.keySet()) {
            for (String item : cube.get(time).keySet()) {
                int sum = 0;
                for (int val : cube.get(time).get(item).values()) {
                    sum += val;

                }
                rollup.computeIfAbsent(time, k -> new HashMap<>()).put(item, sum);

            }
        }
        System.out.println(" rolled up values ");
        for (String time : rollup.keySet()) {
            for (String item : rollup.get(time).keySet()) {
                System.out.println("time " + time + item + rollup.get(time).get(item));
            }
        }

    }
}
