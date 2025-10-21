
import java.util.*;

public class Main10 {
    public static double RatioScaled(double[] a, double[] b) {
        int n = a.length;
        double sum = 0, diff = 0;

        for (int i = 0; i < n; i++) {
            diff = Math.abs(a[i] - b[i]);
            sum += (diff * diff);
        }
        return Math.sqrt(sum);

    }

    public static void main(String[] args) {
        double[][] matrix = {
                { 1.2, 3.5, 5.0 },
                { 2.8, 3.0, 4.5 },
                { 1.0, 2.5, 6.0 }
        };
        int n = matrix.length;
        double[][] res = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                double val = RatioScaled(matrix[i], matrix[j]);
                res[i][j] = val;
                res[j][i] = val;
            }
        }
        for (double[] row : res) {
            System.out.println(Arrays.toString(row));
            System.out.println();
        }

    }

}
