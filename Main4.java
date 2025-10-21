public class Main4 {

    public static double[][] distmat(double[][] data) {
        int n = data.length;
        int m = data[0].length;
        double[][] res = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += Math.pow(data[i][k] - data[j][k], 2);

                }
                res[i][j] = Math.sqrt(sum);
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
        double[][] dismatrix = distmat(matrix);
        for (double[] row : dismatrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();

        }

    }
}
