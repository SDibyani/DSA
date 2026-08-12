class Solution {
    public boolean winnerSquareGame(int n) {
        // dp[i] stores whether the current player can win with i stones remaining
        boolean[] dp = new boolean[n + 1];

        // Fill the DP table up to n
        for (int i = 1; i <= n; i++) {
            // Try removing all possible non-zero square numbers k^2 <= i
            for (int k = 1; k * k <= i; k++) {
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break; // Found a winning move; no need to check further
                }
            }
        }

        return dp[n];
    }
}