class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> m=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int n=nums[i];
            int d=target-n;
            if (m.containsKey(d)){
                return new int[]{m.get(d),i};
            }
            m.put(n,i);
        }
        return new int[0];
        
        }

        
    }

