/**
 * Problem: Trapping Rain Water
 *
 * Given an array of non-negative integers where each element
 * represents the height of a block (width = 1),
 * calculate how much water can be trapped after raining.
 *
 * Approach Used:
 * --------------
 * Prefix Maximum + Suffix Maximum
 *
 * For any index i:
 *   water[i] = min(max height to the left, max height to the right) - height[i]
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(n)
 */
class Solution {

    public int maxWater(int[] arr) {

        int n = arr.length;

        // Edge case:
        // Less than 3 blocks cannot trap any water
        if (n < 3) {
            return 0;
        }

        // pmaxsum[i] -> maximum height from index 0 to i
        // smaxsum[i] -> maximum height from index i to n-1
        int[] pmaxsum = new int[n];
        int[] smaxsum = new int[n];

        int pmax = Integer.MIN_VALUE; // stores prefix maximum
        int smax = Integer.MIN_VALUE; // stores suffix maximum
        int ans = 0;                  // total trapped water

        /* --------------------------------
           Step 1: Build prefix max array
           -------------------------------- */
        for (int i = 0; i < n; i++) {
            if (arr[i] > pmax) {
                pmax = arr[i];
            }
            pmaxsum[i] = pmax;
        }

        /* --------------------------------
           Step 2: Build suffix max array
           -------------------------------- */
        for (int j = n - 1; j >= 0; j--) {
            if (arr[j] > smax) {
                smax = arr[j];
            }
            smaxsum[j] = smax;
        }

        /* --------------------------------
           Step 3: Calculate trapped water
           -------------------------------- */
        // First and last indices cannot trap water
        for (int k = 1; k < n - 1; k++) {

            int leftMax  = pmaxsum[k - 1]; // tallest block on the left
            int rightMax = smaxsum[k + 1]; // tallest block on the right

            int waterLevel = Math.min(leftMax, rightMax);
            int water = waterLevel - arr[k];

            // Add only positive trapped water
            if (water > 0) {
                ans += water;
            }
        }

        return ans;
    }
}

