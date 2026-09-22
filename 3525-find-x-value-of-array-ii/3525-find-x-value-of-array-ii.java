class Node {
    int l, r, prod;
    int[] cnt;

    Node(int l, int r, int k) {
        this.l = l;
        this.r = r;
        this.prod = 1;        // product of segment mod k
        this.cnt = new int[k]; // cnt[r] = number of prefixes with product ≡ r (mod k)
    }
}

class SegmentTree {
    private int k;
    private Node[] tr;

    SegmentTree(int[] nums, int k) {
        this.k = k;
        int n = nums.length;
        tr = new Node[n << 2];
        build(1, 1, n, nums);
    }

    // merge two segment nodes into one
    private Node merge(Node a, Node b) {
        Node c = new Node(0, 0, k);
        c.prod = a.prod * b.prod % k;
        // prefixes entirely in left segment
        System.arraycopy(a.cnt, 0, c.cnt, 0, k);
        // prefixes that take all of left + some of right
        for (int r = 0; r < k; r++) {
            c.cnt[a.prod * r % k] += b.cnt[r];
        }
        return c;
    }

    // update parent from children
    private void pushup(int u) {
        Node p = merge(tr[u << 1], tr[u << 1 | 1]);
        tr[u].prod = p.prod;
        tr[u].cnt = p.cnt;
    }

    // build segment tree
    private void build(int u, int l, int r, int[] nums) {
        tr[u] = new Node(l, r, k);
        if (l == r) {
            int v = nums[l - 1] % k;
            tr[u].prod = v;
            tr[u].cnt[v] = 1;
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid, nums);
        build(u << 1 | 1, mid + 1, r, nums);
        pushup(u);
    }

    // point update: set position x to value v
    void modify(int u, int x, int v) {
        if (tr[u].l == tr[u].r) {
            v %= k;
            tr[u].prod = v;
            Arrays.fill(tr[u].cnt, 0);
            tr[u].cnt[v] = 1;
            return;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (x <= mid) {
            modify(u << 1, x, v);
        } else {
            modify(u << 1 | 1, x, v);
        }
        pushup(u);
    }

    // range query: get merged node for [l, r]
    Node query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u];
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (r <= mid) return query(u << 1, l, r);
        if (l > mid)  return query(u << 1 | 1, l, r);
        return merge(query(u << 1, l, r), query(u << 1 | 1, l, r));
    }
}

class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(nums, k);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int idx   = queries[i][0]; // index to update
            int val   = queries[i][1]; // new value
            int start = queries[i][2]; // prefix to remove
            int x     = queries[i][3]; // target remainder

            // step 1: update nums[idx] = val (persists for future queries)
            tree.modify(1, idx + 1, val);

            // step 2: query [start, n-1] and return count of prefixes with product ≡ x mod k
            ans[i] = tree.query(1, start + 1, n).cnt[x];
        }

        return ans;
    }
}