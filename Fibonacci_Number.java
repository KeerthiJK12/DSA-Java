/*
 * Problem: Fibonacci Number 
 *
 * Goal:
 * - Compute the nth Fibonacci number using recursion.
 *
 * Fibonacci Series Definition:
 *   F(0) = 0
 *   F(1) = 1
 *   F(n) = F(n - 1) + F(n - 2)  for n > 1
 *
 * Example:
 *   Input: n = 5
 *   Output: 5
 *   Explanation: 0 1 1 2 3 5
 *
 * Approach: Recursion
 * - Base Case:
 *      If n == 0 → return 0
 *      If n == 1 → return 1
 * - Recursive Case:
 *      fib(n) = fib(n - 1) + fib(n - 2)
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)  // due to recursion stack
 *
 * Key Insight:
 * - Each call splits into two smaller subproblems,
 *   leading to exponential time complexity.
 */

class Solution {
    public int fib(int n) {

        // Base case: first Fibonacci number
        if(n == 0){
            return 0;
        }

        // Base case: second Fibonacci number
        else if(n == 1){
            return 1;
        }

        // Recursive case
        else{
            return fib(n - 1) + fib(n - 2);
        }
    }
}