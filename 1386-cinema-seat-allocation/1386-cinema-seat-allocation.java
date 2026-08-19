class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] seat: reservedSeats) {
            int row = seat[0], col = seat[1];
            map.put(row, map.getOrDefault(row, 0) | (1 << (col - 1)));
        }
        int count = 2 * n;
        for (int bitmap: map.values()) {
            boolean isBlock0Available = (bitmap & 30) == 0, isBlock1Available = (bitmap & 120) == 0, isBlock2Available = (bitmap & 480) == 0;
            if (isBlock0Available && isBlock2Available)
                continue;
            else if (isBlock0Available || isBlock1Available || isBlock2Available)
                count--;
            else
                count -= 2;
        }
        return count;
    }
}