/*
 * Problem: Longest Consecutive Sequence 
 *
 * Goal:
 * - Find the length of the longest consecutive elements sequence
 *   in an unsorted integer array.
 *
 * Approach: HashSet + Sequence Start Detection
 * - Store all elements in a HashSet for O(1) lookups.
 * - A number is considered the start of a sequence if (num - 1)
 *   does not exist in the set.
 * - From each sequence start, count consecutive numbers.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - Each number is processed at most once when forming sequences,
 *   ensuring linear time complexity.
 */

class Solution {
    public int longestConsecutive(int[] nums) {

        int res = 0;

        // HashSet to store all unique elements
        HashSet<Integer> hs = new HashSet<>();

        // Insert all elements into the set
        for(int num : nums){
            hs.add(num);
        }

        // Iterate through each number in the set
        for(int num : hs){

            // Check if this number is the start of a sequence
            if(!hs.contains(num - 1)){

                int count = 0;

                // Count consecutive numbers starting from num
                while(hs.contains(num)){
                    count++;
                    num++;
                }

                // Update maximum sequence length
                res = Math.max(count, res);
            }
        }

        return res;
    }
}