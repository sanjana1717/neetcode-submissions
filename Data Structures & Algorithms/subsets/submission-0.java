

class Solution { // Defines the Solution class

    public List<List<Integer>> subsets(int[] nums) { // Function that returns all subsets of nums

        List<List<Integer>> resultList = new ArrayList<>(); 
        // resultList stores all the subsets
        // Example: [ [], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3] ]

        backtrack(resultList, new ArrayList<>(), nums, 0); 
        // Start the backtracking function
        // resultList -> stores final answers
        // new ArrayList<>() -> current temporary subset
        // nums -> input array
        // 0 -> start index

        return resultList; 
        // Return all generated subsets
    }

    private void backtrack(List<List<Integer>> resultSets,
                           List<Integer> tempSet,
                           int[] nums,
                           int start) {
        // resultSets -> stores all subsets
        // tempSet -> current subset being built
        // nums -> input array
        // start -> index from where we can choose the next element

        resultSets.add(new ArrayList<>(tempSet)); 
        // Add the current tempSet into resultSets
        // We use new ArrayList<>(tempSet) because we need to store a copy
        // If we directly add tempSet, future changes will affect the stored result

        for (int i = start; i < nums.length; i++) { 
            // Try every number starting from index 'start'
            // This loop decides which number to include next

            tempSet.add(nums[i]); 
            // Choose nums[i]
            // Add current number to tempSet

            backtrack(resultSets, tempSet, nums, i + 1); 
            // Explore further subsets after choosing nums[i]
            // We pass i + 1 because the next number should come after current index
            // This avoids duplicate subsets like [1,2] and [2,1]

            tempSet.remove(tempSet.size() - 1); 
            // Backtrack step
            // Remove the last added number
            // This means undo the choice and try another possibility
        }
    }
}