class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Stores frequency of every task
        // Example:
        // A A A B B C
        // freqMap = {A=3, B=2, C=1}
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count frequency of every task
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // Max Heap
        // Largest frequency always stays on top
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        // Insert only frequencies
        // Example:
        // Heap = [3,2,1]
        maxHeap.addAll(freqMap.values());

        // Final answer
        int time = 0;

        // Continue until every task is completed
        while (!maxHeap.isEmpty()) {

            // Stores tasks executed in this cycle
            // whose frequency is still remaining
            List<Integer> temp = new ArrayList<>();

            // One cycle length = n+1
            // Example:
            // n = 2
            // One cycle = 3 positions
            for (int i = 0; i < n + 1; i++) {

                // If heap still has tasks
                if (!maxHeap.isEmpty()) {

                    // Remove highest frequency task
                    // Example:
                    // Heap : [3,2,1]
                    // poll() -> 3
                    temp.add(maxHeap.poll());
                }
            }

            // Reduce frequency because
            // every selected task has been executed once
            for (int freq : temp) {

                // Execute once
                freq--;

                // If task still remains
                // insert back into heap
                if (freq > 0) {
                    maxHeap.add(freq);
                }
            }

            // If heap becomes empty,
            // last cycle doesn't require idle time
            if (maxHeap.isEmpty()) {
                time += temp.size();
            }

            // Otherwise full cycle is consumed
            else {
                time += n + 1;
            }
        }

        return time;
    }
}