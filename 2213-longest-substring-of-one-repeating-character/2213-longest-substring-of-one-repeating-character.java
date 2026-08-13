class Solution {

    class Node {
        char leftChar, rightChar;
        int leftCount, rightCount, maxCount, length;

        Node(char c) {
            leftChar = rightChar = c;
            leftCount = rightCount = maxCount = 1;
            length = 1;
        }

        Node() {}
    }

    Node[] seg;
    int n;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        n = s.length();
        seg = new Node[4 * n];

        build(1, 0, n - 1, s.toCharArray());

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = seg[1].maxCount;
        }

        return ans;
    }

    void build(int idx, int l, int r, char[] arr) {
        if (l == r) {
            seg[idx] = new Node(arr[l]);
            return;
        }
        int mid = (l + r) / 2;
        build(idx * 2, l, mid, arr);
        build(idx * 2 + 1, mid + 1, r, arr);
        seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1]);
    }

    void update(int idx, int l, int r, int pos, char c) {
        if (l == r) {
            seg[idx] = new Node(c);
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid)
            update(idx * 2, l, mid, pos, c);
        else
            update(idx * 2 + 1, mid + 1, r, pos, c);

        seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1]);
    }

    Node merge(Node a, Node b) {
        Node res = new Node();
        res.length = a.length + b.length;
        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.leftCount = a.leftCount;
        if (a.leftCount == a.length && a.rightChar == b.leftChar)
            res.leftCount += b.leftCount;

        res.rightCount = b.rightCount;
        if (b.rightCount == b.length && a.rightChar == b.leftChar)
            res.rightCount += a.rightCount;

        res.maxCount = Math.max(a.maxCount, b.maxCount);
        if (a.rightChar == b.leftChar)
            res.maxCount = Math.max(res.maxCount, a.rightCount + b.leftCount);

        return res;
    }
}