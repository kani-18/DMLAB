public class Main5 {
    public static double[][] Manhattan(double[][] data) {
        int n = data.length;
        int m = data[0].length;
        double[][] res = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += Math.abs(data[i][k] - data[j][k]);
                }
                res[i][j] = sum;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        double[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        double[][] dismatrix = Manhattan(matrix);
        for (double[] row : dismatrix) {
            for (double val : row) {
                System.out.printf("%.2f. ", val);
            }
            System.out.println();

        }
    }

}
