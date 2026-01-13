/**
 * Applies range update operations and returns the maximum value
 * in the array after all updates.
 *
 * Each operation adds k[i] to all elements in the range [a[i], b[i]].
 *
 * Approach:
 * - Use a difference array to apply range updates efficiently.
 * - Convert it to the final array using prefix sum.
 *
 * Time Complexity  : O(n + q)
 * Space Complexity : O(n)
 */


class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // code here
        int q = a.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int [] arr = new int[n];
        for(int i=0;i<q;i++){
            int s = a[i];
            int e = b[i];
            int v = k[i];
            arr[s] += v;
            if(e+1<n){
                arr[e+1]+=(-v);
            }
        }
        for(int j=0;j<n;j++){
            sum += arr[j];
            arr[j] = sum;
            if(arr[j]>max){
                max = arr[j];
                
            }
            
        }
        return max;
    }
}
