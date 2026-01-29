/*
 * Problem: Contiguous Array (LeetCode 525)
 *
 * Goal:
 * - Find the maximum length of a contiguous subarray
 *   that contains an equal number of 0s and 1s.
 *
 * Approach: Prefix Sum + HashMap
 * - Treat 0 as -1 and 1 as +1.
 * - Maintain a running prefix sum (psum).
 * - If the same prefix sum appears again, it means the subarray
 *   between the two indices has equal 0s and 1s (net sum = 0).
 *
 * Steps:
 * 1. Convert 0 -> -1 and 1 -> +1 while traversing.
 * 2. Store the first occurrence of each prefix sum in a HashMap.
 * 3. When a prefix sum repeats, compute subarray length and update result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - Repeated prefix sum indicates a balanced subarray exists in between.
 */

class Solution {
    public int findMaxLength(int[] nums) {

        // HashMap stores prefixSum -> first index where it occurred
        HashMap<Integer, Integer> hm = new HashMap<>();

        int n = nums.length;
        int psum = 0;
        int res = 0;
        int val;

        // Base case: prefix sum 0 exists before array starts
        hm.put(0, -1);

        for(int i = 0; i < n; i++){

            // Convert 0 to -1, keep 1 as +1
            if(nums[i] == 0){
                psum -= 1;
            }
            else{
                psum += nums[i];
            }

            // If prefix sum is repeated, balanced subarray found
            if(hm.containsKey(psum)){
                val = hm.get(psum);
                int len = i - val;
                res = Math.max(len, res);
            }
            // Store first occurrence of prefix sum
            else{
                hm.put(psum, i);
            }
        }

        return res;
    }
}

