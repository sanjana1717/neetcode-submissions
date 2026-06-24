class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] a2 = new int[2 * n];
        for (int i = 0; i < n; i++) {
            a2[i] = nums[i];
            a2[i + n] = nums[i];
        }
        return a2;
    }
}