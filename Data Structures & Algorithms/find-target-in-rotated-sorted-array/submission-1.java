class Solution {

    public int search(int[] nums, int target) {

        // Store the length of the array
        int n = nums.length;

        // Left pointer starts at the beginning
        int l = 0;

        // Right pointer starts at the end
        int r = n - 1;

        // Continue searching while the search space is valid
        while (l <= r) {

            // Find the middle index
            // This formula avoids integer overflow compared to (l + r) / 2
            int m = l + (r - l) / 2;

            // If middle element is the target, return its index
            if (nums[m] == target) {
                return m;
            }

            // Check if the LEFT half is sorted
            //
            // Example:
            // nums = [4,5,6,7,0,1,2]
            // l = 0, m = 3
            // nums[l] = 4, nums[m] = 7
            //
            // Since 4 <= 7, left half [4,5,6,7] is sorted
            if (nums[l] <= nums[m]) {

                // Now we know left half is sorted.
                // Check if target lies inside this sorted left half.
                //
                // target >= nums[l] means target is at least the left boundary
                // target < nums[m] means target is before middle
                //
                // If true, search left side
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                }

                // Otherwise target is not in the left sorted half,
                // so search the right half
                else {
                    l = m + 1;
                }
            }

            // If left half is not sorted,
            // then the RIGHT half must be sorted
            else {

                // Check if target lies inside the sorted right half.
                //
                // target > nums[m] means target is after middle
                // target <= nums[r] means target is at most the right boundary
                //
                // If true, search right side
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                }

                // Otherwise target is not in the right sorted half,
                // so search the left half
                else {
                    r = m - 1;
                }
            }
        }

        // If target was not found, return -1
        return -1;
    }
}