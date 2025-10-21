import java.util.Arrays;

public class Main19 {

    public static double[] haarwavelet(double[] data) {
        int n = data.length;
        if ((n & (n - 1)) != 0) {
            throw new IllegalArgumentException("length of the data must be a power of 2");
        }
        int half = n / 2;
        double[] res = new double[n];

        for (int i = 0; i < half; i++) {
            res[i] = (data[2 * i] + data[2 * i + 1]) / Math.sqrt(2);
            res[half + i] = (data[2 * i] - data[2 * i + 1]) / Math.sqrt(2);

        }
        return res;

    }

    public static void main(String[] args) {
        double[] data = { 4, 6, 10, 12 };
        double[] result = haarwavelet(data);
        System.out.println(Arrays.toString((result)));

    }

}
