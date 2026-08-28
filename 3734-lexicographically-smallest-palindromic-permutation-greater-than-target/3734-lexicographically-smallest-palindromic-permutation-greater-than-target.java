class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        char[] arr = s.toCharArray();
        char[] targetArr = target.toCharArray();
        int len = arr.length;

        int[] mem = new int[26];
        for (int i = 0; i < len; i++) {
            mem[arr[i] - 'a']++;
        }
        boolean visited = false;
        int foundPos = 0;
        for (int i = 0; i < 26; i++) {
            if (mem[i] > 0 && mem[i] % 2 != 0) {
                if (visited) {
                    return "";
                }
                visited = true;
                foundPos = i;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (mem[i] % 2 == 0) {
                mem[i] /= 2;
            } else {
                mem[i] = (mem[i] / 2) + 1;
            }
        }
        char[] ans = new char[len];
        int index = 0, currLen = len;

        if (len % 2 != 0) {
            ans[len / 2] = (char) (foundPos + 'a');
            mem[foundPos]--;
        }
        len /= 2;
        for (int i = 0; i < len; i++) {
            int pos = targetArr[i] - 'a';
            if (mem[pos] > 0) {
                ans[index++] = targetArr[i];
                mem[pos]--;
            } else {
                int found;
                for (found = pos + 1; found < 26; found++) {
                    if (mem[found] > 0) {
                        break;
                    }
                }
                if (found == 26) {
                    return execute(ans, mem, index - 1, currLen);
                } else {
                    ans[index++] = (char) (found + 'a');
                    mem[found]--;
                    for (int j = 0; j < 26; j++) {
                        if (mem[j] > 0) {
                            ans[index++] = (char) (j + 'a');
                            mem[j]--;
                            j--;
                        }
                    }
                    for (int j = currLen - 1; j >= len; j--) {
                        ans[j] = ans[currLen - j - 1];
                    }
                    return new String(ans);
                }
            }
        }
        for (int j = currLen - 1; j >= len; j--) {
            ans[j] = ans[currLen - j - 1];
        }

        for (int i = 0; i < currLen; i++) {
            if (ans[i] > targetArr[i]) {
                return new String(ans);
            } else if (ans[i] < targetArr[i]) {
                break;
            }
        }
        return execute(ans, mem, len - 1, currLen);
    }
    private String execute(char[] ans,
                                  int[] mem,
                                  int index,
                                  int currLen) {
        if (index == -1) {
            return "";
        }
        while (index >= 0) {
            int curr = ans[index] - 'a';
            int nextMax = curr;
            for (int i = nextMax + 1; i < 26; i++) {
                if (mem[i] > 0) {
                    nextMax = i;
                    break;
                }
            }
            if (nextMax < curr) {
                mem[curr]++;
            } else if (nextMax > curr) {
                mem[curr]++;
                ans[index++] = (char) (nextMax + 'a');
                mem[nextMax]--;
                for (int j = 0; j < 26; j++) {
                    if (mem[j] > 0) {
                        ans[index++] = (char) (j + 'a');
                        mem[j]--;
                        j--;
                    }
                }
                for (int j = currLen - 1; j >= index; j--) {
                    ans[j] = ans[currLen - j - 1];
                }
                return new String(ans);
            } else {
                mem[curr]++;
            }
            index--;
        }
        return "";
    }
}