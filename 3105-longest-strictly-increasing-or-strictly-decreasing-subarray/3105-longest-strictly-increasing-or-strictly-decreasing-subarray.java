class Solution {
     public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int inc = 1;
        int dec = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc += 1;
                dec = 1;
            }
            else if (nums[i - 1] > nums[i]) {
                dec += 1;
                inc = 1;
            }
            else {
                dec = 1;
                inc = 1;
            }
            ans = Math.max(ans, Math.max(inc, dec));
        }
        return ans;
    }
}