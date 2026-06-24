

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Store frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a Min Heap based on frequency
        // pair[0] = number
        // pair[1] = frequency
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        // Step 3: Add every (number, frequency) pair to heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            // Store as {number, frequency}
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});

            // Keep only k elements in heap
            if (minHeap.size() > k) {
                minHeap.poll();      // Removes the smallest frequency
            }
        }

        // Step 4: Prepare answer array
        int[] result = new int[k];

        // Step 5: Extract numbers from heap
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }

        return result;
    }
}