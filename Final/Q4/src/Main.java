public class Main {
//number of possible unique paths, time complexity O(N^2), space complexity is O(N^2)
    public static void main(String[] args) {
	// write your code here
        int[][] obstacleGrid1 = {{0,0,0}, {0,1,0}, {0,0,0}};
        int[][] obstacleGrid2 = {{0,1}, {0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid1));
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        // base case
        dp[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    // pass the square with obstacle
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}




