import java.util.Arrays;

public class Main15 {
    public static void main(String[] args) {
        double[] data = { 1000, 2000, 3000, 9000 };
        int n = data.length;
        double[] res = new double[n];

        double min = data[0];
        double max = min;
        for (int i = 0; i < n; i++) {
            if (data[i] > max) {
                max = data[i];
            } else if (data[i] < min) {
                min = data[i];

            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = data[i] - min / (max - min);
        }
        System.out.println(Arrays.toString(res));
    }

}
