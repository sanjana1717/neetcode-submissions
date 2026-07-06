class Solution {
    public void rotate(int[] nums, int k) {

        // Length of the array
        int n = nums.length;

        // If k is bigger than n, reduce it
        // Example: rotating by 10 in array of size 8
        // is same as rotating by 2
        k = k % n;

        // Create a temporary array
        int[] a = new int[n];

        // Move every element to its new rotated position
        for (int i = 0; i < n; i++) {

            // For right rotation:
            // old index i moves to (i + k) % n
            int newIndex = (i + k) % n;

            // Put nums[i] into its new position
            a[newIndex] = nums[i];
        }

        // Copy the rotated array back into nums
        for (int i = 0; i < n; i++) {
            nums[i] = a[i];
        }
    }
}