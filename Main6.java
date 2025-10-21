public class Main6 {

    // dissimilarity matrix for the categorical variables

    public static void main(String[] args) {
        String[][] data = {
                { "A", "B", "C", "R" },
                { "K", "D", "E", "W" },
                { "E", "B", "L", "Q" }
        };
        int n = data.length;
        int m = data[0].length;
        double[][] res = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    res[i][j] = 0;
                else {
                    int diff = 0;
                    for (int k = 0; k < m; k++) {
                        if (data[i][k] != data[j][k]) {
                            diff += 1;
                            res[i][j] = diff;

                        }
                    }
                    res[i][j] = diff / m;
                }

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
