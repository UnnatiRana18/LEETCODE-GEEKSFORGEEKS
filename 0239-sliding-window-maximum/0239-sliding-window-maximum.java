class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove elements that are outside the window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Start storing answers when first window is complete
            if (i >= k - 1) {
                result[index] = nums[dq.peekFirst()];
                index++;
            }
        }

        return result;
    }
}