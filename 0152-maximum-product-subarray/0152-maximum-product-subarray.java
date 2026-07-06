class Solution {
    public int maxProduct(int[] nums) {
        int pre = 1, suf = 1;
        int res = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            pre *= nums[i];
            res = Math.max(res, pre);
            if (pre == 0) pre = 1;

            suf *= nums[n - 1 - i];
            res = Math.max(res, suf);
            if (suf == 0) suf = 1;
        }

        return res;
    }
}