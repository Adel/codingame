package puzzles.dwarfs;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        HashSet<Integer> roots = new HashSet<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of relationships of influence
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(); // a relationship of influence between two people (x xChildren y)
            int y = in.nextInt();
            if (roots.contains(y)) {
                roots.remove(y);
            }
            roots.add(x);
            List<Integer> xChildren = graph.getOrDefault(x, new ArrayList<>());
            xChildren.add(y);
            graph.put(x, xChildren);
        }
        HashMap<Integer, Integer> memo = new HashMap<>();
        int max = roots.stream()
                .map(r -> dfs(r, graph, memo))
                .max(Integer::compareTo)
                .orElseThrow(RuntimeException::new);
        System.out.println(max);
    }

    protected static int dfs(int root, HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(root)) {
            return memo.get(root);
        } else if (graph.get(root) == null) {
            return 1;
        } else {
            int max = 1 + graph.get(root).stream()
                    .map(e -> dfs(e, graph, memo))
                    .max(Integer::compareTo).orElse(0);
            memo.put(root, max);
            return max;
        }
    }
}
