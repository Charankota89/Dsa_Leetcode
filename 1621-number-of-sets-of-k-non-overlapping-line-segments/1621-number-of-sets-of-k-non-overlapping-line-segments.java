class Solution {
    private static int mod = 1000000007;
    public int numberOfSets(int n, int k) {
        int[][] dp = new int[n][k + 1];



        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }


        for (int j = 1; j <= k; j++) {
            int sum = 0;
            for (int i = n - 2; i >= 0; i--) {
                sum = (sum + dp[i + 1][j - 1]) % mod;
                dp[i][j] = (sum + dp[i + 1][j]) % mod;
            }
        }
        return dp[0][k];
    }
}