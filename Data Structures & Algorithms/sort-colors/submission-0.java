class Solution {
    public void sortColors(int[] nums) {
        int zero=0, one=0;
        for(int two=0;two<nums.length;two++){
            int t=nums[two];
            nums[two]=2;
            if(t<2){
                nums[one++]=1;
            }
            if(t<1){
                nums[zero++]=0;
            }
        }

    }
}