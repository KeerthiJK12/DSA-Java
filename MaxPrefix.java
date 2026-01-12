import java.util.ArrayList;
import java.util.List;

/**
 * Computes the maximum prefix sum for each query range.
 *
 * A prefix sum is calculated from the left index of the range
 * up to any index within the range.
 *
 * Time Complexity  : O(N × Q)
 * Space Complexity : O(1) (excluding result list)
 */
class Solution {

    public List<Integer> maxPrefixes(List<Integer> arr,
                                     List<Integer> leftIndex,
                                     List<Integer> rightIndex) {

        List<Integer> result = new ArrayList<>();
        int queryCount = leftIndex.size();

        for (int i = 0; i < queryCount; i++) {
            int left = leftIndex.get(i);
            int right = rightIndex.get(i);

            int runningSum = 0;
            int maxPrefixSum = Integer.MIN_VALUE;

            for (int j = left; j <= right; j++) {
                runningSum += arr.get(j);
                maxPrefixSum = Math.max(maxPrefixSum, runningSum);
            }

            result.add(maxPrefixSum);
        }

        return result;
    }
}
