class Solution {
    public int distinctSubseqII(String s) {

        int MOD = 1000000007;
        int n = s.length();

        // dp[i] = number of distinct subsequences
        // using first i characters, including empty subsequence
        long[] dp = new long[n + 1];

        dp[0] = 1; // empty subsequence

        // last[c] = number of distinct subsequences
        // that existed before the previous occurrence of character c
        long[] last = new long[26];

        for (int i = 1; i <= n; i++) {

            int c = s.charAt(i - 1) - 'a';

            // Every old subsequence can either:
            // 1. Not take current character
            // 2. Take current character
            //
            // So normally: dp[i] = 2 * dp[i-1]
            //
            // But duplicates are created because c appeared before.
            // Remove those duplicate subsequences.
            dp[i] = (2 * dp[i - 1] - last[c] + MOD) % MOD;

            // Store the number of subsequences that existed
            // before this occurrence of c
            last[c] = dp[i - 1];
        }

        // Remove empty subsequence
        return (int) (dp[n] - 1 + MOD) % MOD;
    }
}