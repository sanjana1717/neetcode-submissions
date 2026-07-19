class Solution {
    public int trap(int[] h) {
        int n=h.length;
        int c=0;
        int[] leftmax= new int[n];
        int[] rightmax=new int[n];
        leftmax[0]=h[0];
        rightmax[n-1]=h[n-1];
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(leftmax[i-1],h[i]);
        }
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],h[i]);
        }
        for(int i=0;i<n;i++){
            c+=Math.min(leftmax[i],rightmax[i])-h[i];

        }
        return c;
    }
}
