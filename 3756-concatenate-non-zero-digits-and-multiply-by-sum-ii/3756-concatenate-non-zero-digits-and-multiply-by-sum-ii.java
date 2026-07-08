class Solution {
    

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int q = queries.length;
        int MOD = 1000000007;
        long[] prefixSum = new long[n + 1];
        long[] prefixNum = new long[n + 1];
        int[] count = new int[n + 1];
        
        long[] powers = new long[n + 1];
        powers[0] = 1;
        for (int i = 1; i <= n; i++) {
            powers[i] = (powers[i - 1] * 10) % MOD;
        }

        char[] sCh = s.toCharArray();
        long currentNum = 0;
        int currentCount = 0;

        for (int i = 0; i < n; i++) {
            int x = sCh[i] - '0';
            
            prefixSum[i + 1] = prefixSum[i] + x;

            if (x > 0) {
                currentNum = (currentNum * 10 + x) % MOD;
                currentCount++;
            }
            
            prefixNum[i + 1] = currentNum;
            count[i + 1] = currentCount;
        }

        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefixSum[r + 1] - prefixSum[l];
          
            int len = count[r + 1] - count[l];
            
            long val = (prefixNum[r + 1] - (prefixNum[l] * powers[len]) % MOD + MOD) % MOD;

            result[i] = (int) ((sum % MOD * val) % MOD);
        }

        return result;
    }
}