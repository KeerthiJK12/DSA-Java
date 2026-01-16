/**
 * Finds the maximum sum of any contiguous subarray of size k.
 *
 * Approach:
 * - Use the Sliding Window technique.
 * - First compute the sum of the first window of size k.
 * - Slide the window by removing the leftmost element
 *   and adding the next element on the right.
 * - Track the maximum sum encountered.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 */

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        long sum = 0;
        int n =arr.length;
        long max= Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum += arr[i];
            if(sum>max){
                max = sum;
            }
            
        }
        int s=1;
        int e=k;
        while(e<n){
            sum += arr[e]-arr[s-1];
            if(sum>max){
                max = sum;
            }
            e++;
            s++;
        }
        return (int)max;
    }
}
