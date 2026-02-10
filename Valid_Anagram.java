/*
 * Problem: Valid Anagram (LeetCode 242)
 *
 * Goal:
 * - Determine whether two strings are anagrams of each other.
 * - Two strings are anagrams if they contain the same characters
 *   with the same frequencies, possibly in a different order.
 *
 * Approach: Frequency HashMaps
 * - If the lengths differ, they cannot be anagrams.
 * - Use two HashMaps to count character frequencies in both strings.
 * - Compare the frequency of each character.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Key Insight:
 * - Anagrams have identical character counts.
 */

class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths differ, strings cannot be anagrams
        if (s.length() != t.length()) return false;

        // HashMaps to store character frequencies
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        // Count frequency of characters in string s
        for (char c : s.toCharArray()) {
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        }

        // Count frequency of characters in string t
        for (char c : t.toCharArray()) {
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
        }

        // Compare character frequencies
        for (char c : hm1.keySet()) {
            if (!hm2.containsKey(c) || !hm1.get(c).equals(hm2.get(c))) {
                return false;
            }
        }

        return true;
    }
}
