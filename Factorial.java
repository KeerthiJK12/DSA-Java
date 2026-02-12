/*
 * Problem: Factorial of a Number
 *
 * Goal:
 * - Compute the factorial of a given number n.
 * - Factorial is defined as:
 *      n! = n × (n - 1) × (n - 2) × ... × 1
 * - By definition:
 *      0! = 1
 *
 * Example:
 *   5! = 5 × 4 × 3 × 2 × 1 = 120
 *
 * Approach: Recursion
 * - Base Case:
 *      If n == 0, return 1.
 * - Recursive Case:
 *      factorial(n) = n × factorial(n - 1)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)  // due to recursion stack
 *
 * Key Insight:
 * - Each recursive call reduces the problem size by 1
 *   until it reaches the base case (0).
 */

class Solution {
    // Function to calculate factorial of a number.
    int factorial(int n) {
        // code here

        // Base case: factorial of 0 is 1
        if(n == 0){
            return 1;
        }

        // Recursive case: n * factorial(n - 1)
        return factorial(n - 1) * n;
    }
}