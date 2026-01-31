/*
 * Problem: Two Sum (Boolean Version)
 *
 * Goal:
 * - Determine if there exists a pair of elements in the array
 *   whose sum is equal to the given target.
 *
 * Approach: HashSet (Complement Check)
 * - Traverse the array while storing visited elements in a HashSet.
 * - For each element arr[i]:
 *      1. Compute the required complement: target - arr[i]
 *      2. If the complement already exists in the set, a valid pair is found.
 *      3. Otherwise, add the current element to the set.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - Using a HashSet allows constant-time lookup for complements.
 */

class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        int n = arr.length;

        // HashSet to store elements seen so far
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < n; i++){

            // Find the value needed to complete the target sum
            int val = target - arr[i];

            // If complement exists, pair is found
            if(hs.contains(val)){
                return true;
            }

            // Store current element for future complement checks
            hs.add(arr[i]);
        }

        return false;
    }
}
