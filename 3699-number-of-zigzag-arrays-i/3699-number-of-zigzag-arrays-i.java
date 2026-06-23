class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[][] dp = new long[2][m];

        for (int x = 0; x < m; x++) {
            dp[0][x] = 1;
            dp[1][x] = 1;
        }

        for (int len = 2; len <= n; len++) {
            long[][] ndp = new long[2][m];
            long[] prefixDown = new long[m + 1];
            long[] suffixUp   = new long[m + 1];

            for (int x = 0; x < m; x++)
                prefixDown[x + 1] = (prefixDown[x] + dp[0][x]) % MOD;

            for (int x = m - 1; x >= 0; x--)
                suffixUp[x] = (suffixUp[x + 1] + dp[1][x]) % MOD;

            for (int x = 0; x < m; x++) {
                ndp[1][x] = prefixDown[x];
                ndp[0][x] = suffixUp[x + 1];
            }

            dp = ndp;
        }

        long total = 0;
        for (int x = 0; x < m; x++)
            total = (total + dp[0][x] + dp[1][x]) % MOD;

        if (n == 1) return (int) (total / 2 % MOD);

        return (int) (total % MOD);
    }
}