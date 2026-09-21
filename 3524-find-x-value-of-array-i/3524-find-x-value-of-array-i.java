import java.util.*;

class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] res = new long[k];

        Map<Integer, Long> freq = new HashMap<>();

        for (int num : nums) {
            Map<Integer, Long> newFreq = new HashMap<>();

            int mod = num % k;
            newFreq.put(mod, newFreq.getOrDefault(mod, 0L) + 1);

            for (Map.Entry<Integer, Long> entry : freq.entrySet()) {
                int newMod = (entry.getKey() * mod) % k;
                newFreq.put(newMod, newFreq.getOrDefault(newMod, 0L) + entry.getValue());
            }

            for (Map.Entry<Integer, Long> entry : newFreq.entrySet()) {
                res[entry.getKey()] += entry.getValue();
            }

            freq = newFreq;
        }

        return res;
    }
}