class Solution {
    public boolean uniformArray(int[] nums) {
        int n = nums.length;

        boolean isAllEven = true;
        boolean isAllOdd = true;

        int min = Integer.MAX_VALUE;        
        for(int i = 0; i < n; i++){
            isAllEven &= (nums[i] % 2 == 0);
            isAllOdd &= (nums[i] % 2 != 0);
            
            min = Math.min(min, nums[i]);
        }

        if(isAllEven || isAllOdd) return true;
        
        if(min % 2 == 0) return false;

        return true;
    }
}