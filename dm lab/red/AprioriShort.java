package red;

import java.util.*;

public class AprioriShort {

    // ---- MAIN FUNCTION ----
    public static void main(String[] args) {

        List<Set<String>> data = List.of(
                Set.of("A", "B", "C"),
                Set.of("A", "C"),
                Set.of("B", "C"),
                Set.of("A", "B"));

        int minSupport = 2;

        List<Set<String>> freq = apriori(data, minSupport);

        System.out.println("Frequent Itemsets:");
        for (Set<String> s : freq)
            System.out.println(s);
    }

    // ---- APRIORI ----
    public static List<Set<String>> apriori(List<Set<String>> data, int minSup) {
        List<Set<String>> allFreq = new ArrayList<>();

        // L1 = single items
        Set<String> items = new HashSet<>();
        for (Set<String> t : data)
            items.addAll(t);

        List<Set<String>> L = new ArrayList<>();
        for (String i : items)
            L.add(Set.of(i));

        while (!L.isEmpty()) {
            List<Set<String>> Lnext = new ArrayList<>();

            // count support
            for (Set<String> cand : L) {
                int count = 0;
                for (Set<String> t : data)
                    if (t.containsAll(cand))
                        count++;

                if (count >= minSup) {
                    allFreq.add(cand);
                    Lnext.add(cand);
                }
            }

            // generate next-level itemsets
            L = join(Lnext);
        }

        return allFreq;
    }

    // ---- JOIN STEP (makes k+1 itemsets) ----
    static List<Set<String>> join(List<Set<String>> prev) {
        List<Set<String>> res = new ArrayList<>();

        for (int i = 0; i < prev.size(); i++) {
            for (int j = i + 1; j < prev.size(); j++) {
                Set<String> a = prev.get(i);
                Set<String> b = prev.get(j);

                Set<String> merged = new HashSet<>(a);
                merged.addAll(b);

                if (merged.size() == a.size() + 1)
                    res.add(merged);
            }
        }

        return res;
    }
}
