// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        int[][] visited = new int[m][n];
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> bfs = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 1 && neighborsZero(mat, i, j, dirs)) {
                    dist[i][j] = 1;
                    bfs.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();
            for (int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if (nr >= 0 && nr < m && nc >=0 && nc < n && visited[nr][nc] == 0 && mat[nr][nc] == 1) {
                    bfs.add(new int[]{nr, nc});
                    visited[nr][nc] = 1;
                }

                if (nr >= 0 && nr < m && nc >=0 && nc < n && dist[nr][nc] != 0) {
                    if (dist[curr[0]][curr[1]] == 0) {
                        dist[curr[0]][curr[1]] = dist[nr][nc] + 1;
                    } else {
                        dist[curr[0]][curr[1]] = Math.min(dist[curr[0]][curr[1]], dist[nr][nc] + 1);
                    }
                }
            }
        }
        return dist;
    }

    public boolean neighborsZero(int[][] mat, int i, int j, int[][] dirs) {
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            if (nr >= 0 && nr < mat.length && nc >=0 && nc < mat[0].length && mat[nr][nc] == 0) {
                return true;
            }
        }
        return false;
    }
}
