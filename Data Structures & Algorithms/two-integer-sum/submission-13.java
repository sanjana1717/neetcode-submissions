class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> p=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            int d=target-n;

            if(p.containsKey(d)){
                return new int[]{p.get(d),i};
            }
            p.put(n,i);
        }
        return new int[]{};
    }
}
