
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        health -= grid.get(0).get(0);
        if (health <= 0) return false;

        int[][] best = new int[n][m];
        for (int[] row : best)
            Arrays.fill(row, -1);

        best[0][0] = health;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, health});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int hp = cur[2];

            if (i == n - 1 && j == m - 1)
                return true;

            if (hp < best[i][j])
                continue;

            for (int[] d : dirs) {
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m)
                    continue;

                int newHp = hp - grid.get(ni).get(nj);

                if (newHp <= 0)
                    continue;

                if (newHp > best[ni][nj]) {
                    best[ni][nj] = newHp;
                    q.offer(new int[]{ni, nj, newHp});
                }
            }
        }

        return false;
    }
}