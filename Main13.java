import java.util.*;

public class Main13 {
    public static double catcorr(String[] a1, String[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        if (n1 != n2) {
            throw new IllegalArgumentException("Arrays must be of equal length");

        }
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int i1 = 0, i2 = 0;
        for (int i = 0; i < n1; i++) {
            if (!map1.containsKey(a1[i])) {
                map1.put(a1[i], i1++);

            }
            if (!map2.containsKey(a2[i])) {
                map2.put(a2[i], i2++);
            }
        }
        int r = map1.size();
        int c = map2.size();
        int[][] table = new int[r][c];
        for (int i = 0; i < n1; i++) {
            table[map1.get(a1[i])][map2.get(a2[i])]++;
        }
        int[] rowsum = new int[r];
        int[] colsum = new int[c];
        int tot = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rowsum[i] += table[i][j];
                colsum[j] += table[i][j];
                tot += table[i][j];

            }
        }
        double chi2 = 0.0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                double expected = (double) rowsum[i] * colsum[j] / tot;
                if (expected != 0) {
                    chi2 += (table[i][j] - expected) * (table[i][j] - expected) / expected;

                }

            }
        }
        int k = Math.min(r - 1, c - 1);
        if (k == 0)
            return 0;
        return Math.sqrt(chi2 / (tot * k));

    }

    public static void main(String[] args) {
        String[] var1 = { "Red", "Blue", "Red", "Green", "Blue", "Red", "Green" };
        String[] var2 = { "Small", "Large", "Small", "Large", "Medium", "Medium", "Large" };

        double cramerV = catcorr(var1, var2);
        System.out.println("Cramer's V: " + cramerV);
    }
}
