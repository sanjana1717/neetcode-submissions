class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> h=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if (h.contains(nums[i])){
                return true;
            }
            h.add(nums[i]);
        }
        return false;

    }
}