import java.util.Scanner;

/**
 * Problem: Magic Triplets
 * 
 * Count the number of triplets (i, j, k) such that:
 * i < j < k and nums[i] < nums[j] < nums[k]
 *
 * Approach:
 * Fix the middle element j and count:
 * - elements smaller than nums[j] on the left
 * - elements greater than nums[j] on the right
 * 
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */

public class MagicTriplets {

    public static int countTriplets(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int j = 1; j < n - 1; j++) {
            int leftLesser = 0;
            int rightGreater = 0;

            // Count smaller elements on the left
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    leftLesser++;
                }
            }

            // Count greater elements on the right
            for (int k = j + 1; k < n; k++) {
                if (nums[k] > nums[j]) {
                    rightGreater++;
                }
            }

            result += leftLesser * rightGreater;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int nums[] = new int[n];

        // input array
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(countTriplets(nums));
    }

}
