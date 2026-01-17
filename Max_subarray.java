/*
 * Problem: Maximum Subarray Sum (Kadane's Algorithm)
 *
 * Approach:
 * - Traverse the array once while maintaining a running sum.
 * - If the running sum becomes negative, reset it to 0 (it won't help future subarrays).
 * - Keep track of the maximum sum encountered at any point.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Why it works:
 * - A negative prefix can only reduce the sum of any subarray that includes it.
 * - Resetting ensures we always start fresh from a better position.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}

