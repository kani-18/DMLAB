public class Main20 {

    public static void main(String[] args) {
        double[] x = { 1, 2, 3, 4, 5 };
        double[] y = { 2, 4, 5, 4, 5 };
        int n = x.length;
        double sumX = 0, sumy = 0, sumx2 = 0, sumy2 = 0, sumxy = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumx2 += x[i] * x[i];
            sumxy = x[i] * y[i];
            sumy += y[i];
            sumy2 = y[i] * y[i];

        }
        double slope = (n * sumxy - sumX * sumy) / (n * sumx2 - sumX * sumX);
        double intercept = (sumy - slope * sumX) / n;

        System.out.println("slope:" + slope);
        System.out.println("intercept" + intercept);

        for (int i = 0; i < n; i++) {
            double ypred = slope * x[i] + intercept;
            System.out.println(ypred);

        }

    }
}
