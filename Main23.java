import java.util.*;

class FPTree {
    String item;
    int count;
    FPTree parent;
    Map<String, FPTree> children;

    FPTree(String item, FPTree parent) {
        this.item = item;
        this.count = 1;
        this.parent = parent;
        this.children = new HashMap<>();
    }

    void increment() {
        this.count++;
    }
}

class SimpleFPGrowth {

    // Get item frequencies with minimum support
    public static Map<String, Integer> getFrequencies(List<List<String>> transactions, int minSupport) {
        Map<String, Integer> freq = new HashMap<>();
        for (List<String> transaction : transactions) {
            for (String item : transaction) {
                freq.put(item, freq.getOrDefault(item, 0) + 1);
            }
        }
        freq.entrySet().removeIf(e -> e.getValue() < minSupport);
        return freq;
    }

    // Build the FP-Tree
    public static FPTree buildFPTree(List<List<String>> transactions, Map<String, Integer> freq) {
        FPTree root = new FPTree(null, null);

        for (List<String> transaction : transactions) {
            List<String> filtered = new ArrayList<>();
            for (String item : transaction) {
                if (freq.containsKey(item))
                    filtered.add(item);
            }
            // Sort items in descending frequency order
            filtered.sort((i1, i2) -> freq.get(i2) - freq.get(i1));
            insertTransaction(root, filtered);
        }

        return root;
    }

    // Insert a transaction into the FP-Tree
    public static void insertTransaction(FPTree node, List<String> transaction) {
        if (transaction.isEmpty())
            return;

        String first = transaction.get(0);
        FPTree child = node.children.get(first);
        if (child == null) {
            child = new FPTree(first, node);
            node.children.put(first, child);
        } else {
            child.increment();
        }

        insertTransaction(child, transaction.subList(1, transaction.size()));
    }

    // Print the FP-Tree recursively
    public static void printTree(FPTree node, String indent) {
        if (node.item != null) {
            System.out.println(indent + node.item + " (" + node.count + ")");
            indent += "  ";
        }

        for (FPTree child : node.children.values()) {
            printTree(child, indent);
        }
    }
}

public class Main23 {
    public static void main(String[] args) {
        List<List<String>> transactions = Arrays.asList(
                Arrays.asList("A", "B", "D"),
                Arrays.asList("B", "C", "E"),
                Arrays.asList("A", "B", "C", "E"),
                Arrays.asList("B", "E"));

        int minSupport = 2;
        Map<String, Integer> freq = SimpleFPGrowth.getFrequencies(transactions, minSupport);
        FPTree root = SimpleFPGrowth.buildFPTree(transactions, freq);

        System.out.println("FP-Tree:");
        SimpleFPGrowth.printTree(root, "");
    }
}
