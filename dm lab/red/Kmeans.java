package red;

import java.util.*;

public class Kmeans {

    public static void main(String[] args) {

        double[][] points = {
                { 1, 1 },
                { 1.5, 2 },
                { 3, 4 },
                { 5, 7 },
                { 3.5, 5 },
                { 4.5, 5 },
                { 3.5, 4.5 }
        };

        int k = 2;
        double[][] centroids = {
                { 1, 1 }, { 5, 7 }
        };
        int[] labels = new int[points.length];

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < points.length; i++) {
                double mindist = Double.MAX_VALUE;
                int bestcentroid = -1;
                for (int j = 0; j < k; j++) {
                    double dist = 0;
                    double dx = points[i][0] - centroids[j][0];
                    double dy = points[i][1] - centroids[j][1];
                    dist = Math.sqrt(dx * dx + dy * dy);
                    if (dist < mindist) {
                        mindist = dist;
                        bestcentroid = j;
                    }
                }
                if (labels[i] != bestcentroid) {
                    labels[i] = bestcentroid;
                    changed = true;

                }
            }
            // recomputing the centroids

            double[][] newcentroids = new double[k][2];
            int[] count = new int[k];
            for (int i = 0; i < points.length; i++) {
                int c = labels[i];
                newcentroids[c][0] += points[i][0];
                newcentroids[c][1] += points[i][1];
                count[c]++;

            }
            for (int i = 0; i < count.length; i++) {
                newcentroids[i][0] /= count[i];
                newcentroids[i][1] /= count[i];

            }
            centroids = newcentroids;

        }
        for (int i = 0; i < points.length; i++) {
            System.out.println("points final label" + labels[i]);
        }
        for (double[] c : centroids) {
            System.out.println(Arrays.toString(c));
        }

    }
}
