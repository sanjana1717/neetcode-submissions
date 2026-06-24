
class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> p =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            p.offer(stones[i]);
        }

        while (p.size() > 1) {
            int l = p.poll();
            int sl = p.poll();

            int diff = l - sl;

            if (diff > 0) {
                p.offer(diff);
            }
        }

        return p.isEmpty() ? 0 : p.peek();
    }
}