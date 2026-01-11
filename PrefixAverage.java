import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem: Prefix Average (Stream of Numbers)
 *
 * Given a list of integers, compute the running (prefix) average.
 * For each index i, the average is:
 * (arr[0] + arr[1] + ... + arr[i]) / (i + 1)
 *
 * Approach:
 * - Maintain a running prefix sum
 * - At each step, divide by (i + 1) to get the average
 *
 * Note:
 * - long is used for prefix sum to prevent integer overflow
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

public class PrefixAverage {

    public static ArrayList<Integer> prefixAvg(ArrayList<Integer> arr) {
        int n = arr.size();
        ArrayList<Integer> result = new ArrayList<>();
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr.get(i);
            result.add((int) (prefixSum / (i + 1))); // integer division
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> input =
                new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println(prefixAvg(input));
    }
}

