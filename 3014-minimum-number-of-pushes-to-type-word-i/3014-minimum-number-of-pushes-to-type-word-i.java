class Solution {
    public int minimumPushes(String word) {
        int w =word.length();
        int ans = 0;
        for (int i = 0; i < w; i++) {
            ans = ans + i / 8 + 1;
        }
        return ans;
    }
}