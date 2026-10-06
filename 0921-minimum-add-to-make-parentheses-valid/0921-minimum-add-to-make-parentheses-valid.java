class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int open = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            } else {
                if (count == 0) {
                    open++;
                } else {
                    count--;

                }
            }
        }
        return open + count;
    }
}