public class Main12 {
    public static void main(String[] args) {

        double[] a1 = { 2.1, 2.5, 3.6, 4.0, 5.2 };
        double[] a2 = { 8, 12, 14, 16 };

        int n = a1.length;
        int m = a2.length;
        if (n != m) {
            System.out.println("attributes of different length ");
        } else {
            double X2 = 0, Y2 = 0, XY = 0, X = 0, Y = 0;
            for (int i = 0; i < n; i++) {
                X += a1[i];
                Y += a2[i];
                X2 += (a1[i] * a1[i]);
                Y2 += (a2[i] * a2[i]);
                XY += (a1[i] * a2[i]);

            }
            double num = n * XY - X * Y;
            double den = Math.sqrt((n * X2 - X * X) * (n * Y2 - Y * Y));
            double ans = num / den;
            System.out.println("corr.   is. " + ans);
        }

    }

}
