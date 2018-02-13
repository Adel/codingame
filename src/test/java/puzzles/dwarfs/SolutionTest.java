package puzzles.dwarfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test void shouldReturnCorrectNumberOfRelationsForTwoElements() {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2));
        HashMap<Integer, Integer> memo = new HashMap<>();
        assertEquals(2, Solution.dfs(1, graph, memo));
    }
    @Test void shouldReturnCorrectDpsForDepthOf3() {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(3));
        HashMap<Integer, Integer> memo = new HashMap<>();
        assertEquals(3, Solution.dfs(1, graph, memo));
    }
    @Test void shouldReturnCorrectDpsForDepthOf5() {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(4));
        graph.put(4, Arrays.asList(5));

        HashMap<Integer, Integer> memo = new HashMap<>();
        assertEquals(5, Solution.dfs(1, graph, memo));
    }
    @Test void shouldReturnCorrectDpsForMultipleChildrenPerParent() {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2,3));
        graph.put(2, Arrays.asList(3,5,6));
        graph.put(3, Arrays.asList(4,7,8));
        graph.put(8, Arrays.asList(10));

        HashMap<Integer, Integer> memo = new HashMap<>();
        assertEquals(5, Solution.dfs(1, graph, memo));
    }
}