/*
Approach:
---------
We use a HashSet to count distinct elements in the array.
HashSet automatically ignores duplicate values, so while traversing
the array, we simply add each element to the set.
After inserting all elements, the size of the HashSet represents
the number of distinct elements in the array.

Time Complexity:
----------------
O(n), where n is the length of the array.
Each insertion into the HashSet takes O(1) on average.

Space Complexity:
-----------------
O(n) in the worst case, when all elements in the array are distinct.
*/

class Solution {
    static int distinct(int arr[]) {
        // code here
        HashSet<Integer> hs = new HashSet<>();
        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            hs.add(arr[i]);
        }
        
        return hs.size();
    }
}
