class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        // List to store the final intervals after insertion and merging
        List<int[]> res = new ArrayList<>();

        // Pointer to traverse all intervals
        int curr = 0;

        // STEP 1:
        // Add all intervals that come completely before newInterval
        // Example:
        // interval = [1,2]
        // newInterval = [5,8]
        // Since 2 < 5, no overlap, so directly add it
        while (curr < intervals.length && intervals[curr][1] < newInterval[0]) {

            // Add current interval to result
            res.add(intervals[curr]);

            // Move to next interval
            curr++;
        }

        // STEP 2:
        // Merge all overlapping intervals with newInterval
        // Example:
        // interval = [1,3]
        // newInterval = [2,5]
        // They overlap, so merge them
        while (curr < intervals.length &&
               intervals[curr][0] <= newInterval[1]) {

            // Take the smaller start value
            newInterval[0] =
                Math.min(newInterval[0], intervals[curr][0]);

            // Take the larger end value
            newInterval[1] =
                Math.max(newInterval[1], intervals[curr][1]);

            // Move to next interval
            curr++;
        }

        // Add the final merged interval
        res.add(newInterval);

        // STEP 3:
        // Add all remaining intervals that come after newInterval
        while (curr < intervals.length) {

            // Add interval to result
            res.add(intervals[curr]);

            // Move to next interval
            curr++;
        }

        // Convert List<int[]> to int[][]
        return res.toArray(new int[res.size()][]);
    }
}