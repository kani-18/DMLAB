import java.util.*;

public class SimpleFPGrowth {

    // ---------- FP TREE NODE ----------
    static class Node {
        String item;
        int count;
        Map<String, Node> children = new HashMap<>();

        Node(String item) {
            this.item = item;
            this.count = 1;
        }
    }

    // ---------- BUILD FP TREE ----------
    static Node buildFPTree(List<List<String>> transactions, int minSup) {
        Map<String, Integer> freq = new HashMap<>();

        // Count frequency
        for (List<String> t : transactions)
            for (String item : t)
                freq.put(item, freq.getOrDefault(item, 0) + 1);

        // Remove infrequent items
        for (Iterator<String> it = freq.keySet().iterator(); it.hasNext();) {
            String item = it.next();
            if (freq.get(item) < minSup)
                it.remove();
        }

        Node root = new Node(null);

        // Insert into FP-tree
        for (List<String> t : transactions) {
            List<String> filtered = new ArrayList<>();
            for (String item : t)
                if (freq.containsKey(item))
                    filtered.add(item);

            filtered.sort((a, b) -> freq.get(b) - freq.get(a));

            Node curr = root;
            for (String item : filtered) {
                curr.children.putIfAbsent(item, new Node(item));
                Node child = curr.children.get(item);
                if (child.item.equals(item))
                    child.count++;
                curr = child;
            }
        }

        return root;
    }

    // ---------- PRINT FP TREE ----------
    static void printTree(Node node, String indent) {
        if (node.item != null)
            System.out.println(indent + node.item + " (" + node.count + ")");

        for (Node child : node.children.values())
            printTree(child, indent + "  ");
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        List<List<String>> transactions = Arrays.asList(
                Arrays.asList("A", "B", "D"),
                Arrays.asList("B", "C"),
                Arrays.asList("A", "C", "D"),
                Arrays.asList("A", "B", "C"),
                Arrays.asList("B", "C", "D"));

        int minSup = 2;

        Node root = buildFPTree(transactions, minSup);

        System.out.println("\nFP-Tree:");
        printTree(root, "");
    }
}
