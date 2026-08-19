class Solution {

    public void setZeroes(int[][] matrix) {

        // Keeps track of whether the original first row contains a 0.
        boolean firstRow = false;

        // Keeps track of whether the original first column contains a 0.
        boolean firstCol = false;


        // STEP 1:
        // Scan the entire matrix and use the first row
        // and first column as markers.
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                // If we find a zero...
                if (matrix[i][j] == 0) {

                    // If the zero is in the first row,
                    // remember that the entire first row
                    // has to become zero later.
                    if (i == 0) {
                        firstRow = true;
                    }

                    // If the zero is in the first column,
                    // remember that the entire first column
                    // has to become zero later.
                    if (j == 0) {
                        firstCol = true;
                    }

                    // Mark this column.
                    // Example: if matrix[1][2] == 0,
                    // make matrix[0][2] = 0.
                    matrix[0][j] = 0;

                    // Mark this row.
                    // Example: if matrix[1][2] == 0,
                    // make matrix[1][0] = 0.
                    matrix[i][0] = 0;
                }
            }
        }


        // STEP 2:
        // Start from index 1 because the first row and first column
        // are currently being used as markers.
        for (int i = 1; i < matrix.length; i++) {

            for (int j = 1; j < matrix[0].length; j++) {

                // If this row OR this column was marked as zero,
                // make the current element zero.
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }
        }


        // STEP 3:
        // If the original first row contained a zero,
        // make the whole first row zero.
        if (firstRow) {

            for (int j = 0; j < matrix[0].length; j++) {

                matrix[0][j] = 0;
            }
        }


        // STEP 4:
        // If the original first column contained a zero,
        // make the whole first column zero.
        if (firstCol) {

            for (int i = 0; i < matrix.length; i++) {

                matrix[i][0] = 0;
            }
        }
    }
}