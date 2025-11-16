package red;

import java.util.*;

public class DBSCAN {
    static double distance(double[] a, double[] b) {
        double sum = 0;
        double x = a[0] - b[0];
        double y = a[1] - b[1];
        sum = Math.sqrt(x * x + y * y);
        return sum;

    }

    static List<Integer> getneighbours(List<double[]> points, int i, double eps) {
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < points.size(); j++) {
            if (distance(points.get(i), points.get(j)) <= eps) {
                res.add(j);
            }
        }
        return res;

    }

    static List<List<double[]>> dbscan(List<double[]> points, double eps, int minpoints) {
        int n = points.size();
        int[] labels = new int[n];
        int clusterid = 0;
        for (int i = 0; i < n; i++) {
            if (labels[i] != 0)
                continue;
            List<Integer> neigh = getneighbours(points, i, eps);
            if (neigh.size() < minpoints) {
                labels[i] = -1;

            } else {
                clusterid += 1;
                for (int idx : neigh) {
                    labels[idx] = clusterid;
                }

            }
        }
        List<List<double[]>> clusters = new ArrayList<>();
        for (int c = 1; c <= clusterid; c++) {
            clusters.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (labels[i] > 0) {
                clusters.get(labels[i] - 1).add(points.get(i));
            }

        }
        return clusters;

    }

    public static void main(String[] args) {
        List<double[]> data = Arrays.asList(
                new double[] { 1, 1 },
                new double[] { 1.2, 1.1 },
                new double[] { 0.8, 0.9 },
                new double[] { 8, 8 },
                new double[] { 8.2, 7.9 },
                new double[] { 7.9, 8.1 });
        List<List<double[]>> clusters = dbscan(data, 0.5, 2);
        int id = 1;
        for (List<double[]> c : clusters) {
            System.out.println("cluster " + id++ + " ");
            for (double[] p : c) {
                System.out.println(Arrays.toString(p));

            }
            System.out.println();
        }
    }

}
