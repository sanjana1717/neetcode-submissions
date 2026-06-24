
class Solution {

    public int[][] merge(int[][] intervals) {

        // If there are 0 or 1 intervals,
        // nothing needs to be merged
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals based on start value
        // Example:
        // [[1,3],[8,10],[2,6]]
        // becomes
        // [[1,3],[2,6],[8,10]]
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        // List to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Take the first interval as the current interval
        int[] newInterval = intervals[0];

        // Add first interval into result
        result.add(newInterval);

        // Traverse every interval
        for (int[] interval : intervals) {

            // Check if current interval overlaps
            // with the last interval in result
            //
            // interval[0] = current start
            // newInterval[1] = previous end
            if (interval[0] <= newInterval[1]) {

                // Overlap found
                //
                // Example:
                // [1,3]
                // [2,6]
                //
                // Start remains 1
                // End becomes max(3,6)=6
                newInterval[1] =
                    Math.max(newInterval[1], interval[1]);

            } else {

                // No overlap
                //
                // Example:
                // [1,6]
                // [8,10]
                //
                // Start a new merged interval
                newInterval = interval;

                // Add new interval into result
                result.add(newInterval);
            }
        }

        // Convert List<int[]> into int[][]
        return result.toArray(new int[result.size()][]);
    }
}