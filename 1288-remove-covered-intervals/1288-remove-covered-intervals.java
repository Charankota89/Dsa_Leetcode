class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        int prev = 0;

        for (int[] ar : intervals) {
            int end = ar[1];
            if (end > prev) {
                count++;
                prev = end;
            }
        }
        return count;
    }
}