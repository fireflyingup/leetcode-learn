package leetcode.editor.cn;

import java.util.Arrays;

public class BeiBao {

    public static void main(String[] args) {
        System.out.println(test(new int[]{2, 3, 4, 5}, new int[]{3, 4, 5, 6}, 8));
    }

    private static int test(int[] A, int[] V, int m) {
        int length = A.length;
        int[][] dp = new int[length + 1][m + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < length + 1; j++) {
                if (i >= A[j - 1]) {
                    dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - A[j - 1]] + V[j - 1]);
                } else {
                    dp[j][i] = dp[j - 1][i];
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return dp[length][m];
    }

}
