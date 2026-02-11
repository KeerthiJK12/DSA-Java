/*
 * Problem:
 * - Given a number N, determine whether N can be expressed
 *   as the sum of consecutive natural numbers starting from 1.
 * - If possible, return the last number used in the sum.
 * - Otherwise, return -1.
 *
 * Example:
 *   N = 6 → 1 + 2 + 3 = 6 → return 3
 *   N = 10 → 1 + 2 + 3 + 4 = 10 → return 4
 *   N = 8 → Not possible → return -1
 *
 * Approach: Recursion
 * - Start adding natural numbers from 1.
 * - Maintain:
 *      1. current → current number being added
 *      2. sum     → running total
 * - Stop when:
 *      • sum == N  → exact match (success)
 *      • sum > N   → exceeded target (failure)
 *
 * Time Complexity: O(k) where k is the last number added
 * Space Complexity: O(k) due to recursion stack
 *
 * Key Insight:
 * - This simulates the sequence:
 *      1, 1+2, 1+2+3, 1+2+3+4, ...
 *   until we either match or exceed N.
 */

class Solution {

    public int find(int N) {
        return helper(1, 0, N);
    }

    private int helper(int current, int sum, int N) {

        // Base Case 1: Exact match found
        if (sum == N) {
            return current - 1;
        }

        // Base Case 2: Sum exceeded target
        if (sum > N) {
            return -1;
        }

        // Recursive call: add current number and move forward
        return helper(current + 1, sum + current, N);
    }
}