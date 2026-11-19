class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1;
        int j = 1;

        while (i < n) {
            if (nums[i] != nums[j - 1]) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }

        return j;
    }
}