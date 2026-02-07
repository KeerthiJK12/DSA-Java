/*
 * Problem: Find Lucky Integer in an Array 
 *
 * Goal:
 * - Find the largest "lucky" integer in the array.
 * - A number is considered lucky if its value is equal
 *   to its frequency in the array.
 * - Return -1 if no lucky integer exists.
 *
 * Approach: Frequency HashMap
 * - First, count the frequency of each number using a HashMap.
 * - Then, iterate through the keys of the map:
 *      1. Check if the number equals its frequency.
 *      2. Track the maximum such number.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - Using a HashMap allows efficient frequency counting
 *   and easy identification of lucky integers.
 */

class Solution {
    public int findLucky(int[] arr) {

        // HashMap stores number -> frequency count
        HashMap<Integer, Integer> hm = new HashMap<>();

        int res = -1;

        // Count frequency of each number
        for(int num : arr){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Check for lucky integers
        for(int elem : hm.keySet()){
            if(elem == hm.get(elem)){
                int curr_res = elem;
                res = Math.max(res, curr_res);
            }
        }

        return res;
    }
}
