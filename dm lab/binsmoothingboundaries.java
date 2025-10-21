import java.util.*;

public class binsmoothingboundaries {
    public static double[] binboundaries(double[] data, int bins) {
        int n = data.length;
        int binssize = n / bins;
        double[] res = new double[n];
        for (int i = 0; i < bins; i++) {
            int s = i * binssize;
            int e = (i == bins - 1) ? n : s + binssize;
            double min = data[s];
            double max = min;
            for (int j = s + 1; j < e; j++) {
                if (data[j] < min) {
                    min = data[j];
                }
                if (data[j] > max) {
                    max = data[j];
                }
            }
            for (int j = s; j < e; j++) {
                double dismin = Math.abs(data[j] - min);
                double dismax = Math.abs(max - data[j]);
                if (dismin < dismax) {
                    res[j] = dismin;
                } else {
                    res[j] = dismax;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        double[] var1 = new double[] { 10.0, 12.0, 13.0, 15.0, 16.0, 20.0, 32.0, 40.0, 45.0 };
        System.out.println("original data" + Arrays.toString(var1));
        double[] var2 = binboundaries(var1, 3);
        System.out.println("smoothened data" + Arrays.toString(var2));

    }
}