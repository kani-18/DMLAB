package red;

import java.util.*;

class CF {
    int n;// this indicates the number of points int the cf
    double[] LS;
    double SS;

    CF(int dim) {
        n = 0;
        LS = new double[dim];
        SS = 0.0;

    }

    void addpoint(double[] point) {
        n += 1;
        for (int i = 0; i < point.length; i++) {
            LS[i] += point[i];
            SS += point[i] * point[i];
        }

    }

    double[] getcentroid() {
        double[] res = new double[LS.length];
        for (int i = 0; i < LS.length; i++) {
            res[i] = LS[i] / n;
        }
        return res;
    }
}

class CFNode {
    List<CF> entries;
    boolean isleaf;
    List<CFNode> children;
    int B;

    CFNode(boolean leaf, int B) {
        this.B = B;
        isleaf = leaf;
        entries = new ArrayList<>();
        children = new ArrayList<>();
    }

    void addentry(CF cf, CFNode child) {
        entries.add(cf);
        if (!isleaf) {
            children.add(child);
        }
    }

}

public class BRICH {

}
