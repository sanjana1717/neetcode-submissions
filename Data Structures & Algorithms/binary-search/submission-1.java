class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0,r=n;
        while(l<r){
            int m=l+(r-l)/2;
            if(nums[m]>=target){
                r=m;
            }
            else{
                l=m+1;
            }
        }
        return (l<nums.length && nums[l]==target)?l:-1;
    }
}
