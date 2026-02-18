/*
 * Problem: Reverse Exponentiation
 *
 * Goal:
 * - Given an integer n:
 *      1. Reverse its digits to form a new number rev.
 *      2. Compute n raised to the power of rev (n^rev).
 *
 * Example:
 *   Input: n = 12
 *   Reverse of 12 = 21
 *   Output: 12^21
 *
 * Approach:
 * Step 1: Reverse the digits of n using a loop.
 * Step 2: Compute n^rev using Binary Exponentiation (Fast Power).
 *
 * Binary Exponentiation:
 *      n^rev = (n^(rev/2))²            if rev is even
 *      n^rev = (n^(rev/2))² × n        if rev is odd
 *
 * Time Complexity:
 * - Reversal: O(d)  where d = number of digits
 * - Power:    O(log rev)
 *
 * Space Complexity: O(log rev)  // recursion stack
 *
 * Key Insight:
 * - Using fast power reduces time from O(rev)
 *   to O(log rev).
 */

class Solution {
    public int reverseExponentiation(int n) {
        // code here
        int rev = 0;
        int N = n;

        // Reverse the digits of n
        while(N > 0){
            int digit = N % 10;
            rev = rev * 10 + digit;
            N = N / 10;
        }

        return power(n, rev);
    }
    
    public int power(int n, int rev){
        
        // Base case
        if(rev == 0){
            return 1;
        }
        
        int half = power(n, rev / 2);
        
        // If exponent is even
        if(rev % 2 == 0){
            return half * half;
        }
        // If exponent is odd
        else{
            return half * half * n;
        }
    }
}