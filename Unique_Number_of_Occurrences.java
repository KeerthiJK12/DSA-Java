/*
 * Problem: Unique Number of Occurrences 
 *
 * Goal:
 * - Determine whether the number of occurrences of each value
 *   in the array is unique.
 *
 * Approach: HashMap + HashSet
 * - Use a HashMap to count the frequency of each number.
 * - Use a HashSet to track frequencies already seen.
 * - If a frequency repeats, return false.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - HashMap handles frequency counting.
 * - HashSet ensures all frequencies are unique.
 */

class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        // HashMap stores number -> frequency count
        HashMap<Integer, Integer> hm = new HashMap<>();

        // HashSet stores frequencies to ensure uniqueness
        HashSet<Integer> hs = new HashSet<>();

        // Count frequency of each number
        for(int num : arr){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Check if all frequencies are unique
        for(int num : hm.keySet()){
            if(hs.contains(hm.get(num))){
                return false;
            }
            hs.add(hm.get(num));
        }

        return true; 
    }
}
