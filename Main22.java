import java.util.*;

public class Main22 {

    public static List<Set<String>> generateCandidates(List<Set<String>> freqItemsets, int k) {
        List<Set<String>> candidates = new ArrayList<>();
        int size = freqItemsets.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                Set<String> union = new HashSet<>(freqItemsets.get(i));
                union.addAll(freqItemsets.get(j));
                if (union.size() == k && !candidates.contains(union)) {
                    candidates.add(union);
                }
            }
        }
        return candidates;
    }

    public static void apriori(List<Set<String>> transactions, double minSupport) {
        int totalTransactions = transactions.size();
        Map<Set<String>, Integer> itemCounts = new HashMap<>();

        // Count frequency of individual items
        for (Set<String> transaction : transactions) {
            for (String item : transaction) {
                Set<String> single = new HashSet<>(Collections.singletonList(item));
                itemCounts.put(single, itemCounts.getOrDefault(single, 0) + 1);
            }
        }

        // Generate frequent 1-itemsets
        List<Set<String>> freqItemSets = new ArrayList<>();
        for (Map.Entry<Set<String>, Integer> entry : itemCounts.entrySet()) {
            if ((double) entry.getValue() / totalTransactions >= minSupport) {
                freqItemSets.add(entry.getKey());
                System.out.println("Frequent itemset: " + entry.getKey() + " Support: "
                        + (double) entry.getValue() / totalTransactions);
            }
        }

        int k = 2;
        while (!freqItemSets.isEmpty()) {
            List<Set<String>> candidates = generateCandidates(freqItemSets, k);
            Map<Set<String>, Integer> candidateCounts = new HashMap<>();

            for (Set<String> transaction : transactions) {
                for (Set<String> candidate : candidates) {
                    if (transaction.containsAll(candidate)) {
                        candidateCounts.put(candidate, candidateCounts.getOrDefault(candidate, 0) + 1);
                    }
                }
            }

            List<Set<String>> newFrequentItemSets = new ArrayList<>();
            for (Map.Entry<Set<String>, Integer> entry : candidateCounts.entrySet()) {
                if ((double) entry.getValue() / totalTransactions >= minSupport) {
                    newFrequentItemSets.add(entry.getKey());
                    System.out.println("Frequent itemset: " + entry.getKey() + " Support: "
                            + (double) entry.getValue() / totalTransactions);
                }
            }

            freqItemSets = newFrequentItemSets;
            k++;
        }
    }

    public static void main(String[] args) {
        List<Set<String>> transactions = Arrays.asList(
                new HashSet<>(Arrays.asList("A", "B", "C")),
                new HashSet<>(Arrays.asList("A", "C")),
                new HashSet<>(Arrays.asList("B", "C")),
                new HashSet<>(Arrays.asList("A", "B")),
                new HashSet<>(Arrays.asList("A", "B", "C")));

        double minSupport = 0.6;
        apriori(transactions, minSupport);
    }
}
