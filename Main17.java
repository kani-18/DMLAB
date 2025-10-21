
import java.util.Arrays;

public class Main17 {
    // decimal scling
    public static void main(String[] args) {
        double[] data = { 1200, 540, -980, 1350 };
        double maxabs = 0;
        for (int i = 0; i < data.length; i++) {
            if (Math.abs(data[i]) > maxabs) {
                maxabs = Math.abs(data[i]);
            }
        }
        int j = 0;
        while (maxabs >= 1) {
            maxabs /= 10;
            j++;
        }
        double scaler = Math.pow(10, j);
        double[] res = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            res[i] = data[i] / scaler;

        }
        System.out.println(Arrays.toString(res));
    }
}
