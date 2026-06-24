
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k = m + n;

        int[] a = new int[k];

        for(int i = 0; i < k; i++) {
            if(i < n) {
                a[i] = nums1[i];
            }
            else {
                a[i] = nums2[i - n];
            }
        }

        Arrays.sort(a);

        if(k % 2 != 0) {
            return a[k / 2];
        }
        else {
            return (a[k / 2 - 1] + a[k / 2]) / 2.0;
        }
    }
}