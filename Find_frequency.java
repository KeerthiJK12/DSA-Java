/*
Approach:
---------
We use a HashMap to store the frequency of each element in the array.
Traverse the array once and for every element:
- If the element already exists in the HashMap, increment its count.
- Otherwise, insert the element with an initial count of 1.
Finally, return the frequency of element `x` using getOrDefault(),
which safely returns 0 if `x` is not present in the map.

Time Complexity:
----------------
O(n), where n is the length of the array.
Each insertion and lookup in HashMap takes O(1) on average.

Space Complexity:
-----------------
O(n) in the worst case, when all elements in the array are unique.
*/

class Solution {
    int findFrequency(int arr[], int x) {
        // code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = arr.length;
        int val = 0;
        
        for(int i = 0; i < n; i++){
            if(hm.containsKey(arr[i])){
                val = hm.get(arr[i]);
                hm.put(arr[i], val + 1);
            }
            else{
                hm.put(arr[i], 1);
            }
        }
        return hm.getOrDefault(x, 0);
    }
}
