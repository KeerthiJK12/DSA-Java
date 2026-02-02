/*
 * Problem: Count Number of Pairs With Absolute Difference K
 *
 * Goal:
 * - Given an integer array nums and an integer k,
 *   return the number of pairs (i, j) such that:
 *      i < j and |nums[i] - nums[j]| == k
 *
 * Approach: Frequency HashMap (One-Pass Counting)
 * - Use a HashMap to store the frequency of elements seen so far.
 * - For each number num:
 *      1. Check how many times (num - k) has appeared → contributes valid pairs
 *      2. Check how many times (num + k) has appeared → contributes valid pairs
 *      3. Add num to the frequency map
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - Each element forms valid pairs only with previously seen numbers,
 *   ensuring i < j automatically.
 */

class Solution {
    public int countKDifference(int[] nums, int k) {

        // Stores frequency of numbers seen so far
        HashMap<Integer, Integer> freq = new HashMap<>();

        int count = 0;

        // Traverse array once
        for (int num : nums) {

            // Count pairs where difference = k
            count += freq.getOrDefault(num - k, 0);

            // Count pairs where difference = -k
            count += freq.getOrDefault(num + k, 0);

            // Add current number to map
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}

