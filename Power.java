/*
 * Problem: Pow(x, n) 
 *
 * Goal:
 * - Compute x raised to the power n (i.e., xⁿ).
 *
 * Approach: Binary Exponentiation (Fast Power)
 * - Instead of multiplying x n times (O(n)),
 *   divide the problem using recursion:
 *
 *      xⁿ = (x^(n/2)) * (x^(n/2))         if n is even
 *      xⁿ = (x^(n/2)) * (x^(n/2)) * x     if n is odd
 *
 * - Handle negative powers by:
 *      x⁻ⁿ = (1/x)ⁿ
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(log n)  // due to recursion stack
 *
 * Key Insight:
 * - Each recursive call halves the exponent,
 *   reducing time complexity from O(n) to O(log n).
 */

class Solution {
    public double myPow(double x, int n) {
        
        long N = n;
        
        // Handle negative exponent
        if(N < 0){
            x = 1 / x;
            N = -N;
        }
        
        return fastPow(x, N);
    }
    
    public double fastPow(double x, long n){
        
        // Base case
        if(n == 0){
            return 1;
        }
        
        // Recursive call
        double half = fastPow(x, n / 2);
        
        // If n is even
        if(n % 2 == 0){
            return half * half;
        }
        // If n is odd
        else{
            return half * half * x;
        }
    }
}
