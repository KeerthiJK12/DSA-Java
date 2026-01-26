class Solution {

    /*
     * ✅ Approach:
     * We need to find the intersection of two integer arrays such that:
     * - Each element in the result must be unique
     * - Order does not matter
     *
     * Steps:
     * 1. Store all elements of nums1 into a HashSet (set1) for fast lookup.
     * 2. Traverse nums2 and check if an element exists in set1.
     * 3. If yes, add it to another HashSet (resultSet) to ensure uniqueness.
     * 4. Convert the resultSet into an integer array and return it.
     *
     * ✅ Time Complexity:
     * - Inserting nums1 into set: O(n)
     * - Checking nums2 elements: O(m)
     * - Overall: O(n + m)
     *
     * ✅ Space Complexity:
     * - HashSet storage: O(n)
     * - Result set storage: O(k)
     * - Overall: O(n)
     */

    public int[] intersection(int[] nums1, int[] nums2) {

        // Store elements of nums1 in a set
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Store intersection elements in another set
        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert resultSet to array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}
