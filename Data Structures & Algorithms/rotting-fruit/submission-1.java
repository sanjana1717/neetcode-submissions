

public class Solution {

    public int orangesRotting(int[][] grid) {

        // Queue stores rotten orange positions
        Queue<int[]> q = new ArrayDeque<>();

        // Count fresh oranges
        int fresh = 0;

        // Time taken
        int time = 0;

        // Step 1: Traverse grid
        // Count fresh oranges and add rotten oranges to queue
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == 1) {
                    fresh++;
                }

                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        // Step 2: BFS starts
        while (fresh > 0 && !q.isEmpty()) {

            // Number of rotten oranges at current minute
            int length = q.size();

            // Process only current minute oranges
            for (int i = 0; i < length; i++) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                // Instead of directions array,
                // we manually check all 4 sides

                // Up
                if (rotOrange(grid, q, r - 1, c)) {
                    fresh--;
                }

                // Down
                if (rotOrange(grid, q, r + 1, c)) {
                    fresh--;
                }

                // Left
                if (rotOrange(grid, q, r, c - 1)) {
                    fresh--;
                }

                // Right
                if (rotOrange(grid, q, r, c + 1)) {
                    fresh--;
                }
            }

            // One BFS level completed = one minute passed
            time++;
        }

        // If all fresh oranges are rotten, return time
        // Otherwise return -1
        return fresh == 0 ? time : -1;
    }

    // This function checks one cell
    // If it is a fresh orange, make it rotten and add to queue
    private boolean rotOrange(int[][] grid, Queue<int[]> q, int r, int c) {

        // Check boundaries
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length) {
            return false;
        }

        // If it is not a fresh orange, do nothing
        if (grid[r][c] != 1) {
            return false;
        }

        // Make fresh orange rotten
        grid[r][c] = 2;

        // Add newly rotten orange to queue
        // It will rot others in the next minute
        q.offer(new int[]{r, c});

        return true;
    }
}