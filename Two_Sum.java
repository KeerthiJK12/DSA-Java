/*
 * Problem: Two Sum 
 *
 * Goal:
 * - Return the indices of two numbers in the array such that
 *   they add up exactly to the given target.
 *
 * Approach: HashMap (Value -> Index)
 * - Use a HashMap to store numbers we have already seen along with their indices.
 * - For each element nums[i]:
 *      1. Compute the complement needed: target - nums[i]
 *      2. If the complement exists in the map, we have found the pair
 *         and store both indices in the result array.
 *      3. Otherwise, store the current number with its index for future lookup.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - HashMap allows constant-time lookup of the required complement.
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Result array to store the two indices
        int[] arr = new int[2];

        // HashMap stores number -> index
        HashMap<Integer, Integer> hm = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < n; i++){

            // Calculate the complement needed to reach the target
            int val = target - nums[i];

            // If complement exists, pair found
            if(hm.containsKey(val)){
                int index = hm.get(val);
                arr[0] = index;
                arr[1] = i;
            }

            // Store current number with its index for future reference
            hm.put(nums[i], i);
        }

        return arr;
    }
}
