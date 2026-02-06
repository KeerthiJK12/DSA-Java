/*
 * Problem: Count Distinct Elements in Every Window of Size K
 *
 * Goal:
 * - Given an array and an integer k, return a list containing
 *   the count of distinct elements in every contiguous subarray (window) of size k.
 *
 * Approach: Sliding Window + HashMap
 * - Use a HashMap to maintain the frequency of elements in the current window.
 * - Initialize the map with the first window of size k.
 * - Slide the window one element at a time:
 *      1. Remove the outgoing element from the window.
 *      2. Add the incoming element to the window.
 *      3. Store the size of the HashMap (number of distinct elements).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 *
 * Key Insight:
 * - The HashMap size always represents the number of distinct elements
 *   in the current window.
 */

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;

        // HashMap stores element -> frequency in current window
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Process first window of size k
        for(int i = 0; i < k; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        // Add distinct count of first window
        res.add(hm.size());

        int s = 0;
        int e = k;

        // Slide the window across the array
        while(e < n){

            // Remove outgoing element
            if(hm.containsKey(arr[s])){
                hm.put(arr[s], hm.getOrDefault(arr[s], 0) - 1);
                if(hm.get(arr[s]) < 1){
                    hm.remove(arr[s]);
                }
            }

            // Add incoming element
            hm.put(arr[e], hm.getOrDefault(arr[e], 0) + 1);

            // Store distinct count for current window
            res.add(hm.size());

            s++;
            e++;
        }

        return res;
    }
}
