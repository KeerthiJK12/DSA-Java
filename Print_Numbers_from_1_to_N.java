/*
 * Problem: Print Numbers from 1 to N
 *
 * Goal:
 * - Print numbers in increasing order from 1 to N
 *   using recursion.
 *
 * Example:
 *   Input: N = 5
 *   Output: 1 2 3 4 5
 *
 * Approach: Recursion (Backtracking)
 * - Base Case:
 *      If N == 0, stop recursion.
 * - Recursive Case:
 *      1. First call function for N - 1
 *      2. Then print current number N
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)  // due to recursion stack
 *
 * Key Insight:
 * - Printing after the recursive call ensures
 *   numbers are printed in increasing order.
 */

class Solution {

    static void printTillN(int N) {
        // code here

        // Base case: stop when N becomes 0
        if(N == 0){
            return;
        }

        // Recursive call
        printTillN(N - 1);

        // Print current number
        System.out.print(N + " ");
    }
}