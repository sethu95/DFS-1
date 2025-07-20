// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

// We perform a dfs recursive approach starting from sr sc and expanding to all 4 directions

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int dirs[][] = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (image[sr][sc] == color) return image;

        int oldColor = image[sr][sc];

        image[sr][sc] = color;

        return dfs(image, sr, sc, color, dirs, oldColor);
    }

    public int[][] dfs(int[][] image, int sr, int sc, int color, int[][] dirs, int oldColor) {
        for (int [] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];

            if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == oldColor) {
                image[nr][nc] = color;
                dfs(image, nr, nc, color, dirs, oldColor);
            }
        }

        return image;
    }
}
