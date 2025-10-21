
import java.util.*;

public class Main9 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("L", 1);
        map.put("M", 2);
        map.put("H", 3);

        String[][] matrix = {
                { "L", "M", "H" },
                { "M", "L", "H" },
                { "H", "M", "L" }
        };
        int n = matrix.length;
        double[][] res = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diss = 0;
                for (int k = 0; k < n; k++) {
                    int r1 = map.get(matrix[i][k]);
                    int r2 = map.get(matrix[j][k]);
                    diss += Math.abs(r2 - r1);

                }
                res[i][j] = diss;

            }

        }
        for (double[] row : res) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

}
