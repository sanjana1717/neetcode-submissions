class Solution {
    public int maxArea(int[] h) {
        int l=0,r=h.length-1;
        int m=0;
        while(l<r){
            int a=Math.min(h[l],h[r])*(r-l);
            m=Math.max(m,a);
            if(h[l]<=h[r]){
                l++;
            }
            else{
                r--;
            }
        }
return m;
        
    }
}
