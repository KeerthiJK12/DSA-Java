class Solution {

    /*
     * Problem:
     * Given an array and an integer k, we can swap any two elements.
     * Find the minimum number of swaps required to bring all elements
     * less than or equal to k together as a contiguous subarray.
     *
     * Approach:
     * 1. Count how many elements are <= k (these are the "good" elements).
     * 2. Use a sliding window of size equal to this count.
     * 3. Count how many "bad" elements (> k) exist in each window.
     * 4. The minimum number of bad elements in any window
     *    equals the minimum number of swaps required.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    int minSwap(int[] arr, int k) {

        int n = arr.length;

        // Step 1: Count elements less than or equal to k
        // This determines the size of the sliding window
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                count++;
            }
        }

        // Step 2: Count "bad" elements (> k) in the first window
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > k) {
                bad++;
            }
        }

        // Initial answer based on the first window
        int ans = bad;

        // Step 3: Slide the window across the array
        int i = 0, j = count;
        while (j < n) {

            // Remove the effect of the element leaving the window
            if (arr[i] > k) {
                bad--;
            }

            // Add the effect of the new element entering the window
            if (arr[j] > k) {
                bad++;
            }

            // Update the minimum swaps required
            ans = Math.min(ans, bad);

            i++;
            j++;
        }

        return ans;
    }
}
