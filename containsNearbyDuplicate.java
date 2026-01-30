/*
 * Problem: Contains Duplicate 
 *
 * Goal:
 * - Determine if the array contains two identical values such that
 *   the difference between their indices is at most k.
 *
 * Approach: HashMap (Value -> Last Seen Index)
 * - Use a HashMap to store the most recent index of each number.
 * - While traversing:
 *      1. If the number has been seen before, calculate index distance.
 *      2. If distance <= k, return true immediately.
 *      3. Otherwise, update the stored index to the current one.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - Storing the latest index ensures we always check the closest duplicate.
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // HashMap stores number -> last index where it appeared
        HashMap<Integer, Integer> hm = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < n; i++){

            // If current number was seen before
            if(hm.containsKey(nums[i])){

                int val = hm.get(nums[i]);

                // Compute distance between duplicate indices
                int res = Math.abs(val - i);

                // If distance is within allowed range, duplicate exists nearby
                if(res <= k){
                    return true;
                }
                // Otherwise, update the index to the latest occurrence
                else{
                    hm.put(nums[i], i);
                }
            }
            // First time seeing this number, store its index
            else{
                hm.put(nums[i], i);
            }
        }

        return false;
    }
}
