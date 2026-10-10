class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int operations = k1 + k2;
        int n = nums1.length;
        int[] map = new int[(int) 1e5 + 1];
        
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums1[i] - nums2[i]);
            map[x]++;
        }

        for(int i = (int)1e5 ; i >= 1;i--){

            if(map[i] > operations){
                map[i - 1] += operations;
                map[i] -= operations;
                operations = 0;
                break;
            }else{
                map[i - 1] += map[i];
                operations -= map[i];
                map[i] = 0;
            }
        }

        long sum = 0;

        for(int i = 0;i<=(int)1e5;i++){
            sum += (i * 1L * i * 1L * map[i]);
        }

        return sum;
    }
}