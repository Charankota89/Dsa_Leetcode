class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        int even=0;
        int odd=0;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0){
                even++;
                
            }
            else{
                odd++;
            }
        }
        if(odd==0){
            return true;
        }
        if(even==0){
            return true;
        }
        return true;
    }
}