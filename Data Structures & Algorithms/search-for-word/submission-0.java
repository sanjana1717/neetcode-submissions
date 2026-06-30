public class Solution { // Defines the Solution class

    private int ROWS, COLS; 
    // ROWS and COLS are global variables
    // ROWS stores number of rows in the board
    // COLS stores number of columns in the board

    public boolean exist(char[][] board, String word) { 
        // Main function called by LeetCode
        // board = 2D grid of characters
        // word = word we need to search in the board

        ROWS = board.length; 
        // Number of rows in the board

        COLS = board[0].length; 
        // Number of columns in the board

        for (int r = 0; r < ROWS; r++) { 
            // Loop through every row

            for (int c = 0; c < COLS; c++) { 
                // Loop through every column in the current row

                if (dfs(board, word, r, c, 0)) { 
                    // Start DFS from cell board[r][c]
                    // 0 means we are trying to match word.charAt(0), the first character
                    // If DFS returns true, the word exists in the board

                    return true; 
                    // If word is found from this starting cell, return true immediately
                }
            }
        }

        return false; 
        // If no starting cell can form the word, return false
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) { 
        // DFS function tries to match word starting from index i
        // r = current row
        // c = current column
        // i = current index of word we are trying to match

        if (i == word.length()) { 
            // If i reaches word length, it means all characters are matched

            return true; 
            // Full word found
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
            board[r][c] != word.charAt(i) || board[r][c] == '#') { 
            // This checks invalid conditions:
            // r < 0 means row went above the board
            // c < 0 means column went left outside the board
            // r >= ROWS means row went below the board
            // c >= COLS means column went right outside the board
            // board[r][c] != word.charAt(i) means current board character does not match current word character
            // board[r][c] == '#' means this cell was already visited in the current path

            return false; 
            // If any invalid condition happens, this path cannot form the word
        }

        board[r][c] = '#'; 
        // Mark the current cell as visited
        // We use '#' so that we do not use the same cell again in the same word path

        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                      // Move down: row increases by 1
                      // i + 1 means now we try to match the next character of the word

                      dfs(board, word, r - 1, c, i + 1) ||
                      // Move up: row decreases by 1
                      // Try to match next character

                      dfs(board, word, r, c + 1, i + 1) ||
                      // Move right: column increases by 1
                      // Try to match next character

                      dfs(board, word, r, c - 1, i + 1);
                      // Move left: column decreases by 1
                      // Try to match next character

        board[r][c] = word.charAt(i); 
        // Backtracking step
        // Restore the original character after exploring all 4 directions
        // This allows this cell to be used again in a different path

        return res; 
        // Return true if any one of the 4 directions found the word
        // Otherwise return false
    }
}