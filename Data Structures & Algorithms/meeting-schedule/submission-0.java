

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        // Sort all meetings based on start time
        // Example:
        // [15,20], [0,30], [5,10]
        //
        // becomes:
        // [0,30], [5,10], [15,20]
        intervals.sort((a, b) -> a.start - b.start);

        // Start from the second meeting
        for (int i = 1; i < intervals.size(); i++) {

            // End time of previous meeting
            int prevEnd = intervals.get(i - 1).end;

            // Start time of current meeting
            int start = intervals.get(i).start;

            // If current meeting starts before
            // previous meeting ends,
            // meetings overlap
            if (start < prevEnd) {
                return false;
            }
        }

        // No overlaps found
        return true;
    }
}