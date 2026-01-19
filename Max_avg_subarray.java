class Solution {

    // Finds the maximum average of any contiguous subarray of size k
    // Uses the Sliding Window technique for O(n) time complexity
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;

        // Variable to store the sum of the current window
        double sum = 0;

        // Variable to store the average of the current window
        double avg = 0;

        // Step 1: Calculate the sum (and average) of the first window of size k
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            avg = sum / k;   // Average of the first complete window
        }

        // Initialize answer with the average of the first window
        double ans = avg;

        // Step 2: Slide the window across the array
        for (int j = 1; j <= n - k; j++) {

            // Add the next element in the window and remove the element leaving the window
            sum += nums[j + (k - 1)] - nums[j - 1];

            // Calculate average for the current window
            avg = sum / k;

            // Update maximum average if current window average is greater
            if (avg > ans) {
                ans = avg;
            }
        }

        // Return the maximum average found
        return ans;
    }
}

