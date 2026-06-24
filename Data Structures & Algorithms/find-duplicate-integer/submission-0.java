class Solution {
    public int findDuplicate(int[] nums) {

        // slow and fast both start at index 0
        int slow = 0, fast = 0;

        // Phase 1: Find meeting point inside the cycle
        while (true) {

            // slow moves one step
            slow = nums[slow];

            // fast moves two steps
            fast = nums[nums[fast]];

            // If both meet, cycle exists
            if (slow == fast) {
                break;
            }
        }

        // Phase 2: Find entrance of the cycle
        int slow2 = 0;

        while (true) {

            // Move slow one step
            slow = nums[slow];

            // Move slow2 one step from start
            slow2 = nums[slow2];

            // Where they meet is duplicate number
            if (slow == slow2) {
                return slow;
            }
        }
    }
}