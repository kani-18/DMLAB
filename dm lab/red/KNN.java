package red;

import java.util.*;

public class KNN {
    public static void main(String[] args) {
        double[][] data = {
                { 1, 2, 0 },
                { 2, 3, 0 },
                { 3, 3, 0 },
                { 6, 5, 1 },
                { 7, 7, 1 },
                { 8, 6, 1 }
        };
        List<double[]> distances = new ArrayList<>();
        double testX = 4;
        double testY = 4;
        int k = 3;
        for (double[] row : data) {
            double dx = row[0] - testX;
            double dy = row[1] - testY;
            double diff = Math.sqrt(dx * dx + dy * dy);
            distances.add(new double[] { diff, row[2] });

        }
        distances.sort(Comparator.comparingDouble(a -> a[0]));

        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < k; i++) {
            if (distances.get(i)[1] == 0) {
                count0++;

            } else {
                count1++;

            }
        }
        int predcition = (count0 > count1) ? 0 : 1;
        System.out.println("predicted is " + predcition);

    }
}
