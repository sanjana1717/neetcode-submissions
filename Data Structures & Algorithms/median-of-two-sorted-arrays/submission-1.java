class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;

        int i = 0;
        int j = 0;
        int count = 0;

        int prev = 0;
        int curr = 0;

        // We only need to go until the middle element
        while (count <= total / 2) {

            prev = curr;

            // Take the smaller element using two pointers
            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }

            count++;
        }

        // Odd number of total elements
        if (total % 2 == 1) {
            return curr;
        }

        // Even number of total elements
        return (prev + curr) / 2.0;
    }
}