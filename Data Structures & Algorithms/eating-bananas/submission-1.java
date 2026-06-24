class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;

        int max = Arrays.stream(piles).max().getAsInt();

        int l = 1;
        int r = max;
        int ans = max;

        while(l <= r) {

            int m = l + (r - l) / 2;

            int s = 0;

            for(int i = 0; i < n; i++) {
                s = s + (piles[i] + m - 1) / m;
            }

            if(s <= h) {
                ans = m;
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        return ans;
    }
}