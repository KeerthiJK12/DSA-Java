/*
Approach:
---------
We use the Prefix Sum technique along with a HashSet to detect
whether a subarray with sum equal to 0 exists.

Key Idea:
- Maintain a running prefix sum while traversing the array.
- If the same prefix sum is seen again, it means the elements
  between the two occurrences sum to 0 (because the difference is zero).
- Also, if the prefix sum itself becomes 0 at any point, it indicates
  a subarray from the start has sum 0.

Steps:
1. Initialize a HashSet to store prefix sums.
2. Add 0 initially to handle the case where a prefix sum becomes 0.
3. Traverse the array:
   - Update the running sum.
   - If the sum already exists in the set, return true.
   - Otherwise, store the sum in the set.
4. If no duplicate prefix sum is found, return false.

Time Complexity:
----------------
O(n), where n is the size of the array.
Each HashSet lookup and insertion takes O(1) on average.

Space Complexity:
-----------------
O(n) in the worst case, to store all unique prefix sums.
*/

class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        // Your code here
        HashSet<Integer> hs = new HashSet<>();
        hs.add(0);
        
        int sum = 0;
        
        for(int nums : arr){
            sum += nums;
            
            if(hs.contains(sum)){
                return true;
            }
            
            hs.add(sum);
        }
        
        return false;
    }
}

