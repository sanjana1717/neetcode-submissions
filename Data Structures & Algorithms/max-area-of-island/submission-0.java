class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // Store the maximum island area found so far
        int maxArea = 0;

        // Loop through every row
        for (int i = 0; i < grid.length; i++) {

            // Loop through every column
            for (int j = 0; j < grid[0].length; j++) {

                // If we find land
                if (grid[i][j] == 1) {

                    // Find full island area using DFS
                    int area = dfs(grid, i, j);

                    // Update maximum area
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        // Return biggest island area
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {
        // Boundary check and water check
        if (i < 0 || j < 0 || 
            i >= grid.length || j >= grid[0].length || 
            grid[i][j] == 0) {
            return 0;
        }

        // Mark current land cell as visited by changing it to water
        grid[i][j] = 0;

        // Count current cell as 1
        int area = 1;

        // Add area from down
        area += dfs(grid, i + 1, j);

        // Add area from up
        area += dfs(grid, i - 1, j);

        // Add area from right
        area += dfs(grid, i, j + 1);

        // Add area from left
        area += dfs(grid, i, j - 1);

        // Return total area of this island
        return area;
    }
}