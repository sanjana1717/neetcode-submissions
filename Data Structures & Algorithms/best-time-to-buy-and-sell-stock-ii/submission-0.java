class Solution {
    public int maxProfit(int[] p) {
        int pr=0;
        for(int i=1;i<p.length;i++){
            if(p[i]>p[i-1]){
                pr+=(p[i]-p[i-1]);
            }
        }
        return pr;
        
    }
}