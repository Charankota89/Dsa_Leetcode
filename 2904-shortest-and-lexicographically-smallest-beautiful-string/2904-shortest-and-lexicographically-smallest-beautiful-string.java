class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int totalOnes = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                totalOnes++;
            }
        }

        if (totalOnes < k) {
            return "";
        }

        int left = 0;
        int countOne = 0;

        String res = "";

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                countOne++;
            }

            while (
                countOne > k ||
                (left <= right && s.charAt(left) == '0')
            ) {
                if (s.charAt(left) == '1') {
                    countOne--;
                }

                left++;
            }

            if (countOne == k) {
                String current =
                    s.substring(left, right + 1);

                if (
                    res.isEmpty() ||
                    current.length() < res.length() ||
                    (
                        current.length() == res.length() &&
                        current.compareTo(res) < 0
                    )
                ) {
                    res = current;
                }
            }
        }

        return res;
    }
}