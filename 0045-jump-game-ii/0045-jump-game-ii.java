
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;    // counts minimum number of jumps
        int maxJump = 0;   // stores the farthest index we 
                                            //can reach
        int end = 0;                          
     //Stores the boundary of the current jump range.
        for (int i = 0; i < n - 1; i++) {
                // n-1    becoz we dont have to jump from last index

            maxJump = Math.max(maxJump, nums[i] + i);

            if (end == i) {
                jumps++;
                end = maxJump;
            }
        }

        return jumps;
    }
}
