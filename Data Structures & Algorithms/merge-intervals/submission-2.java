
class Solution {
    public int[][] merge(int[][] intervals) {

        // Create a list to store final merged intervals
        List<int[]> res = new ArrayList<>();

        // Sort intervals based on start value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // i is used to move through intervals
        int i = 0;

        // Loop until all intervals are checked
        while (i < intervals.length) {

            // nint stores the current interval we are trying to merge
            int[] nint = {
                intervals[i][0],
                intervals[i][1]
            };

            // Check next intervals while they overlap with nint
            while (i < intervals.length - 1 &&
                   nint[1] >= intervals[i + 1][0]) {

                // Update end of nint with the bigger end value
                nint[1] = Math.max(nint[1], intervals[i + 1][1]);

                // Move to the next interval because it got merged
                i++;
            }

            // Add the fully merged interval to result
            res.add(nint);

            // Move to the next unmerged interval
            i++;
        }

        // Convert List<int[]> to int[][]
        return res.toArray(new int[res.size()][]);
    }
}