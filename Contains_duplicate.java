/*
Approach:
---------
We use a HashSet to detect duplicates in the array.
While traversing the array, each element is added to the HashSet.
Since HashSet stores only unique values, any duplicate elements
will not increase its size.
After inserting all elements:
- If the size of the HashSet equals the array length, no duplicates exist.
- Otherwise, at least one duplicate is present.

Time Complexity:
----------------
O(n), where n is the number of elements in the array.
Each insertion into the HashSet takes O(1) on average.

Space Complexity:
-----------------
O(n) in the worst case, when all elements are distinct.
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            hs.add(nums[i]);
        }
        
        if(hs.size() == n){
            return false;
        }
        return true;
    }
}

