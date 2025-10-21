import java.util.Arrays;

public class Main11 {
    public static double[] means(double[][] data) {
        int r = data.length;
        int c = data[0].length;
        double[] res = new double[c];
        double sum = 0;
        int count = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (!Double.isNaN(data[j][i])) {
                    sum += data[j][i];
                    count++;

                }
            }
            res[i] = (count > 0) ? sum / count : 0;

        }
        return res;
    }

    public static void main(String[] args) {
        double[][] data = {
                { 1.0, Double.NaN, 3.0 },
                { 4.0, 5.0, Double.NaN },
                { Double.NaN, 2.0, 1.0 },
        };
        double mean[] = means(data);
        for (double[] row : data) {
            System.out.println(Arrays.toString(row));
            System.out.println();
        }
        System.out.println("original");
        for (int j = 0; j < data[0].length; j++) {
            for (int i = 0; i < data.length; i++) {
                if (Double.isNaN(data[i][j])) {
                    data[i][j] = mean[j];
                }
            }
        }
        System.out.println("calcualted means ");
        for (double[] row : data) {
            System.out.println(Arrays.toString(row));
            System.out.println();
        }

    }

}
