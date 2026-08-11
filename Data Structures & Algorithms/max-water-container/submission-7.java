class Solution {
    public int maxArea(int[] h) {
        int l=0;
        int r=h.length-1;
        int res=0;
        while(l<r){
            int a=Math.min(h[l],h[r])*(r-l);
            res=Math.max(res,a);
            if(h[l]<=h[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
