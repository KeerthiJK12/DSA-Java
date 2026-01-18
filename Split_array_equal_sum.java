 /*
 * Problem: Check if Array Can Be Split into Two Equal Sum Parts
 *
 * Approach:
 * - First, compute the total sum of the array.
 * - Traverse the array while maintaining a prefix sum.
 * - At each index, compare the prefix sum with the remaining sum.
 * - If both are equal at any point, a valid split exists.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Key Insight:
 * - If prefixSum == totalSum - prefixSum,
 *   the array can be split into two parts with equal sum.
 */

class Split_array_equal_sum {
    public boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        int psum = 0;
        int tsum = 0;
        int diff = 0;

        // Calculate total sum of the array
        for(int i = 0; i < n; i++){
            tsum += arr[i];
        }

        // Traverse and check for equal prefix and suffix sums
        for(int j = 0; j < n; j++){
            psum += arr[j];
            diff = tsum - psum; 
            if(psum == diff){
                return true;
            }
        }
        return false;
    }
}
