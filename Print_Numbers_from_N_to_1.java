/*
 * Problem: Print Numbers from N to 1
 *
 * Goal:
 * - Print numbers in decreasing order starting from N down to 1
 *   using recursion.
 *
 * Example:
 *   Input: N = 5
 *   Output: 5 4 3 2 1
 *
 * Approach: Recursion
 * - Base Case:
 *      If N == 0, stop recursion.
 * - Recursive Case:
 *      1. Print current number N
 *      2. Call function for N - 1
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)  // due to recursion stack
 *
 * Key Insight:
 * - Each recursive call prints one number
 *   and reduces the problem size by 1.
 */

class Solution {

    void printNos(int N) {
        // code here

        // Base case: stop when N becomes 0
        if(N == 0){
            return;
        }

        // Print current number
        System.out.print(N + " ");

        // Recursive call for next number
        printNos(N - 1);
    }
}
