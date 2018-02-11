package puzzles.thegift;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int prize = in.nextInt();
        int[] budgets = new int[n];
        for (int i = 0; i < n; i++) {
            budgets[i] = in.nextInt();
        }
        if (isPossible(prize, budgets)) {
            int[] contributions = getContributions(prize, budgets);
            for (int i = 0; i < contributions.length; i++) {
                System.out.println(contributions[i]);
            }
        } else {
            System.out.println(IMPOSSIBLE);
        }
    }

    protected static boolean isPossible(int prize, int[] budgets) {
        return prize <= IntStream.of(budgets).sum();
    }

    public static int[] getContributions(int prize, int[] budgets) {
        Arrays.sort(budgets);
        int nextPrize = prize;
        int[] results = new int[budgets.length];
        for (int i = 0; i < budgets.length; i++) {
            int contribution = nextPrize / (budgets.length - i);
            results[i] = budgets[i] > contribution ? contribution : budgets[i];
            nextPrize = nextPrize - results[i];
        }
        return results;
    }

}
