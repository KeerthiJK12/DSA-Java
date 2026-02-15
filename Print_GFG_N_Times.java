/*
 * Problem: Print "GFG" N Times
 *
 * Goal:
 * - Print the string "GFG" exactly N times using recursion.
 *
 * Example:
 *   Input: N = 3
 *   Output: GFG GFG GFG
 *
 * Approach: Recursion
 * - Base Case:
 *      If N == 0, stop recursion.
 * - Recursive Case:
 *      1. Print "GFG"
 *      2. Call function for N - 1
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)  // due to recursion stack
 *
 * Key Insight:
 * - Each recursive call handles one print operation
 *   and reduces the problem size by 1.
 */

class Solution {

    void printGfg(int N) {
        // code here

        // Base case: stop when N becomes 0
        if(N == 0){
            return;
        }

        // Print "GFG"
        System.out.print("GFG" + " ");

        // Recursive call
        printGfg(N - 1);
    }
}
