class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            while(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l=i+1;int r=n-1;
            while(l<r){
                int k=nums[i]+nums[l]+nums[r];
                if(k>0){
                    r--;
                }else if(k<0){
                    l++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }
            }
        

                }
                return res;
            }

}