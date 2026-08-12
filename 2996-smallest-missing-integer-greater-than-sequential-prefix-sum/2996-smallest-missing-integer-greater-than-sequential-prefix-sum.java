import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {
        // Step 1: Calculate the sum of the longest sequential prefix
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break; // Sequential chain broke
            }
        }

        // Step 2: Store all numbers in a HashSet for fast lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 3: Find the smallest integer >= sum that is missing from nums
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}