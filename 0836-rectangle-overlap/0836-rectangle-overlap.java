class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int left1 = Math.min(rec1[0], rec1[2]);
        int right1 = Math.max(rec1[0], rec1[2]);
        int left2 = Math.min(rec2[0], rec2[2]);
        int right2 = Math.max(rec2[0], rec2[2]);

        int bottom1 = Math.min(rec1[1], rec1[3]);
        int top1 = Math.max(rec1[1], rec1[3]);
        int bottom2 = Math.min(rec2[1], rec2[3]);
        int top2 = Math.max(rec2[1], rec2[3]);

        return !(right1 <= left2 || right2 <= left1 ||
                 top1 <= bottom2 || top2 <= bottom1);
    }
}