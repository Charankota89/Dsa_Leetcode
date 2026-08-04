class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        boolean[] flag = new boolean[101];
        for(int num : nums){
            largest = Math.max(largest, num);
            smallest = Math.min(smallest, num);
            flag[num] = true;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = smallest; i <= largest; i++){
            if(!flag[i]){
                list.add(i);
            }
        }
        return list;
    }
}