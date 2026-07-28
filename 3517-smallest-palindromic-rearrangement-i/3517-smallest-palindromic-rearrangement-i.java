class Solution {

    public String smallestPalindrome(String s) {
        int p = s.length();
        int part = p / 2;

        char[] chars = s.toCharArray();
        Arrays.sort(chars, 0, part);

        for (int i = 0; i < part; i++) {
            chars[p - 1 - i] = chars[i];
        }

        return new String(chars);
    }
}