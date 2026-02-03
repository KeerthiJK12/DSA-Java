/*
 * Problem: Count Subarrays With Sum = 0
 *
 * Goal:
 * - Given an integer array, return the number of subarrays
 *   whose sum is equal to 0.
 *
 * Approach: Prefix Sum + HashMap Frequency
 * - Use a running prefix sum (psum).
 * - If the same prefix sum appears multiple times,
 *   it means the subarray between those occurrences has sum 0.
 *
 * Steps:
 * 1. Maintain prefix sum while traversing the array.
 * 2. Store the frequency of each prefix sum in a HashMap.
 * 3. If current prefix sum already exists,
 *    add its frequency to the count (valid zero-sum subarrays).
 * 4. Update the prefix sum frequency in the map.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - Repeated prefix sums indicate zero-sum subarrays in between.
 */

class Solution {
    public int findSubarray(int[] arr) {
        // code here.
        int n = arr.length;

        // HashMap stores prefixSum -> frequency count
        HashMap<Integer, Integer> hm = new HashMap<>();

        int psum = 0;
        int count = 0;

        // Base case: prefix sum 0 occurs once before starting
        hm.put(0, 1);

        for(int i = 0; i < n; i++){

            // Update running prefix sum
            psum += arr[i];

            // Target sum is 0, so we check current prefix sum itself
            int target = psum - 0;

            // Add number of times this prefix sum has occurred before
            count += hm.getOrDefault(target, 0);

            // Update frequency of current prefix sum
            hm.put(psum, hm.getOrDefault(target, 0) + 1);
        }

        return count;
    }
}

