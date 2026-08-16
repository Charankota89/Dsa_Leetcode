class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){          
                nums[left] = nums[i];  
                left++;                
            }
        }
        while(left < nums.length){
            nums[left] = 0;
            left++;
        }
        
    }
}