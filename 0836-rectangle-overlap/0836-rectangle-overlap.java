class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax1 = rec1[0], ay1 = rec1[1];
        int ax2 = rec1[2], ay2 = rec1[3];
        int bx1 = rec2[0], by1 = rec2[1];
        int bx2 = rec2[2], by2 = rec2[3];
        if (bx1 >= ax2) return false;
        if (bx2 <= ax1) return false;
        if (by1 >= ay2) return false;
        if (by2 <= ay1) return false;
        return true;
    }
}