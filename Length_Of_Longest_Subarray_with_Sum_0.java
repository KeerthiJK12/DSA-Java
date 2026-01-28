/*
 * Problem: Find the Length of the Largest Subarray with Sum = 0
 *
 * Approach:
 * - Use Prefix Sum + HashMap to track cumulative sums.
 * - If the same prefix sum occurs again, it means the elements
 *   between those two indices sum to 0.
 * - Store the first occurrence of each prefix sum to maximize length.
 *
 * Steps:
 * 1. Maintain a running prefix sum (psum).
 * 2. If psum is already present in the map:
 *      - Subarray between previous index and current index has sum 0.
 *      - Update the maximum length.
 * 3. Otherwise, store the prefix sum with its index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - Repeated prefix sum implies zero-sum subarray exists in between.
 */

class Solution {
    int maxLength(int arr[]) {
        // code here
        int n = arr.length;
        int val;
        int psum = 0;
        int res = 0;

        // HashMap stores prefixSum -> first index where it occurred
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Base case: prefix sum 0 occurs before the array starts
        hm.put(0, -1);

        for(int i = 0; i < n; i++){
            psum += arr[i];

            // If prefix sum already exists, zero-sum subarray found
            if(hm.containsKey(psum)){
                val = hm.get(psum);
                int len = i - val;
                res = Math.max(len, res);
            }
            // Store the first occurrence of this prefix sum
            else{
                hm.put(psum, i);
            }
        }

        return res;
    }
}

