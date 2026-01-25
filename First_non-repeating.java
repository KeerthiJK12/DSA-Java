/*
Approach:
---------
We use a HashMap to find the first non-repeating element in the array.

Step 1:
Traverse the array and store the frequency of each element in the HashMap:
- If the element already exists, increment its count.
- Otherwise, insert it with frequency 1.

Step 2:
Traverse the array again in the original order and return the first element
whose frequency is exactly 1.

If no such element exists, return 0.

Time Complexity:
----------------
O(n), where n is the size of the array.
- First traversal builds the frequency map: O(n)
- Second traversal finds the first non-repeating element: O(n)

Space Complexity:
-----------------
O(n) in the worst case, when all elements are distinct and stored in the map.
*/

class Solution {
    public int firstNonRepeating(int[] arr) {
        // Complete the function
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = arr.length;
        int val;
        
        for(int i = 0; i < n; i++){
            if(hm.containsKey(arr[i])){
                val = hm.get(arr[i]);
                hm.put(arr[i], val + 1);
            }
            else{
                hm.put(arr[i], 1);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(hm.get(arr[i]) == 1){
                return arr[i];
            }
        }
        
        return 0;
    }
}

