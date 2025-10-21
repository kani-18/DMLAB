import java.util.Arrays;

public class Main16 {
    // z score normalization

    public static void main(String[] args) {
        double[] data = { 1000, 2000, 3000, 9000 };
        int n = data.length;
        double[] res = new double[n];
        double sum = 0, mean = 0, std = 0;
        for (int i = 0; i < n; i++) {
            sum += data[i];

        }
        mean = sum / n;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (data[i] - mean) * (data[i] - mean);

        }
        sum /= n;
        std = Math.sqrt(sum);

        for (int i = 0; i < n; i++) {
            res[i] = data[i] - mean / std;

        }
        System.out.println(Arrays.toString(res));

    }
}
