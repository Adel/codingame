package puzzles.thegift;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    void findIfPossible() {
        int[] budgets = {50, 50, 50, 49};
        assertFalse(Solution.isPossible(200, budgets));
        assertTrue(Solution.isPossible(150, budgets));
        assertTrue(Solution.isPossible(199, budgets));
    }

    @Test
    @DisplayName("correct distribution for one element")
    void shouldGetCorrectContributions() {
        assertArrayEquals(new int[]{100}, Solution.getContributions(100, new int[]{100}));
    }

    @Test
    @DisplayName("correct distribution for three elements")
    void shouldGetCorrectContributions2() {
        assertArrayEquals(new int[]{3, 45, 52}, Solution.getContributions(100, new int[]{3, 45, 100}));
    }


    @Test
    @DisplayName("correct distribution for three elements")
    void shouldGetCorrectContributions3() {
        assertArrayEquals(new int[]{3, 48, 49}, Solution.getContributions(100, new int[]{3, 100, 100}));
    }


    @Test
    @DisplayName("correct distribution if everyone has same budget")
    void shouldGetCorrectContributions4() {
        assertArrayEquals(new int[]{33, 33, 34}, Solution.getContributions(100, new int[]{40, 40, 40}));
    }

    @Test
    @DisplayName("correct distribution if budgets are not sorted")
    void shouldGetCorrectContributions5() {
        assertArrayEquals(new int[]{1, 49, 50}, Solution.getContributions(100, new int[]{100, 100, 1}));
    }
}