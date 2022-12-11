public class Main {
    public static void main(String[] args) {
//number-of-islands, time complexity O(N^2) space complexity O(N^2)
        String[][] matrix = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };

        System.out.println("Number of Islands = " + numIslands(matrix));
    }

    public static int numIslands(String[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        // traversal grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == "1") {
                    // found one, add one
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public static void dfs(String[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // out of bounds
            return;
        }
        if (grid[i][j] == "0") {
            // it's water, just return
            return;
        }
        grid[i][j] = "0";
        // continue to dfs for the surroundings
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

}