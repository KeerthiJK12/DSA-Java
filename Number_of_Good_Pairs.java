/*
 * Problem: Number of Good Pairs 
 *
 * Goal:
 * - Count the number of pairs (i, j) such that:
 *      i < j and nums[i] == nums[j]
 *
 * Approach: Frequency HashMap (One-Pass)
 * - Use a HashMap to store how many times each number
 *   has appeared so far.
 * - For each nums[i]:
 *      1. The current number forms valid pairs with all
 *         its previous occurrences.
 *      2. Add the current frequency to the count.
 *      3. Increment the frequency of the number.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - Every new occurrence of a number contributes
 *   as many pairs as its previous count.
 */

class Solution {
    public int numIdenticalPairs(int[] nums) {

        int n = nums.length;

        // HashMap stores number -> frequency count
        HashMap<Integer, Integer> hm = new HashMap<>();

        int count = 0;

        for(int i = 0; i < n; i++){

            // Add number of previous occurrences of nums[i]
            count += hm.getOrDefault(nums[i], 0);

            // Update frequency of nums[i]
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        return count;
    }
}
