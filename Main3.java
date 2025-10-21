import java.util.*;

public class Main3 {
    public static double[] BinMedian(double[] data, int bins) {
        int n = data.length;
        double[] res = new double[n];
        int binssize = n / bins;
        for (int i = 0; i < bins; i++) {
            int s = i * binssize;
            int e = (i == bins - 1) ? n : s + binssize;
            double[] newdata = Arrays.copyOfRange(data, s, e);
            Arrays.sort(newdata);
            int k = newdata.length;
            double median = 0;
            if (k % 2 == 0) {
                median = (newdata[k / 2 - 1] + newdata[k / 2]) / 2;
            } else {
                median = newdata[k / 2];
            }
            for (int j = s; j < e; j++) {
                res[j] = median;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        double[] var1 = new double[] { 10.0, 12.0, 13.0, 15.0, 16.0, 20.0, 32.0, 40.0, 45.0 };
        System.out.println("original data" + Arrays.toString(var1));
        double[] var2 = BinMedian(var1, 3);
        System.out.println("smoothened data" + Arrays.toString(var2));

    }

}
