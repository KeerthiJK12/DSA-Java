/*
 * Problem: Subarray Sum Equals K 
 *
 * Goal:
 * - Return the total number of continuous subarrays
 *   whose sum is exactly equal to k.
 *
 * Approach: Prefix Sum + HashMap Frequency
 * - Maintain a running prefix sum (psum).
 * - If at index i, prefixSum = psum,
 *   then we need a previous prefix sum = psum - k
 *   to form a subarray with sum k.
 *
 * Steps:
 * 1. Traverse the array while updating prefix sum.
 * 2. For each psum, compute target = psum - k.
 * 3. Add the frequency of target prefix sums to the count.
 * 4. Store/update the frequency of current prefix sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - HashMap helps count how many times a required prefix sum
 *   has occurred before, enabling efficient subarray counting.
 */

class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;

        // HashMap stores prefixSum -> frequency count
        HashMap<Integer, Integer> hm = new HashMap<>();

        int count = 0;
        int psum = 0;

        // Base case: prefix sum 0 occurs once before array starts
        hm.put(0, 1);

        for(int i = 0; i < n; i++){

            // Update running prefix sum
            psum += nums[i];

            // Required prefix sum to form subarray sum = k
            int target = psum - k;

            // Add number of times target prefix sum has occurred
            count += hm.getOrDefault(target, 0);

            // Update frequency of current prefix sum
            hm.put(psum, hm.getOrDefault(psum, 0) + 1);
        }

        return count;
    }
}

