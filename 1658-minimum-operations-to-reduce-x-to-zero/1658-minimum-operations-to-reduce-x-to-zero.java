class Solution {
    public int minOperations(int[] nums, int x) {
 
        int n = nums.length;
        int maxLen = -1;
        int totalSum = 0;
        for(int i=0; i<n; i++) totalSum += nums[i];
        int target = totalSum - x;
        if(target==0) return n;


        int sum = 0;
        int l = 0;
        for(int r=0; r<n; r++){
            sum += nums[r];

            while(l<=r && sum>target){
                sum -= nums[l];
                l++;
            }

            if(sum==target){
                maxLen = Math.max(maxLen, r-l+1);
            }
        }

        return maxLen==-1? -1 : n-maxLen;
    }
}