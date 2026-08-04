public class Solution {

    // Stores all valid quadruplets
    private List<List<Integer>> res;

    // Stores the numbers selected in the current recursive path
    private List<Integer> quad;

    public List<List<Integer>> fourSum(int[] nums, int target) {

        // Sort the array so we can use two pointers
        // and easily skip duplicate values
        Arrays.sort(nums);

        // Initialize the final result list
        res = new ArrayList<>();

        // Initialize the current combination
        quad = new ArrayList<>();

        // Start by finding 4 numbers from index 0
        // whose sum equals target
        kSum(nums, 4, 0, target);

        return res;
    }

    private void kSum(int[] nums, int k, int start, long target) {

        // Base case:
        // When only two numbers are required,
        // solve using two pointers
        if (k == 2) {

            int l = start;
            int r = nums.length - 1;

            while (l < r) {

                // Calculate the sum of the current pair
                long sum = (long) nums[l] + nums[r];

                // Sum is too small, so move left pointer right
                if (sum < target) {
                    l++;
                }

                // Sum is too large, so move right pointer left
                else if (sum > target) {
                    r--;
                }

                // Pair sum equals the remaining target
                else {

                    // Copy the already selected numbers
                    List<Integer> current = new ArrayList<>(quad);

                    // Add the two numbers found by two pointers
                    current.add(nums[l]);
                    current.add(nums[r]);

                    // Add the complete combination to the result
                    res.add(current);

                    // Move both pointers
                    l++;
                    r--;

                    // Skip duplicate values on the left
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    // Skip duplicate values on the right
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }

            return;
        }

        // Choose one number and recursively find the remaining numbers
        for (int i = start; i < nums.length - k + 1; i++) {

            // Skip duplicate values at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose the current number
            quad.add(nums[i]);

            // Find k - 1 more numbers
            // Start from the next index
            // Reduce target by the selected value
            kSum(nums, k - 1, i + 1, target - nums[i]);

            // Backtrack by removing the selected number
            quad.remove(quad.size() - 1);
        }
    }
}