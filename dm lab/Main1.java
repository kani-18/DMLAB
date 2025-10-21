import java.util.*;

public class Main1 {
    public static double[] binSmoothing(double[] data, int bins) {
        int n = data.length;
        int binssize = n / bins;
        double[] res = new double[n];
        for (int i = 0; i < binssize; i++) {
            int s = i * binssize;
            int e = (i == binssize - 1) ? n : s + binssize;
            double sum = 0;
            for (int j = s; j < e; j++) {
                sum += data[j];
            }
            double mean = sum / (e - s);
            for (int j = s; j < e; j++) {
                res[j] = mean;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        double[] data = { 10, 12, 13, 15, 16, 20, 32, 40, 45 };
        System.out.println("original data" + Arrays.toString(data));
        double[] smoothened_data = binSmoothing(data, 3);
        System.out.println("smoothened data" + Arrays.toString(smoothened_data));

    }

}