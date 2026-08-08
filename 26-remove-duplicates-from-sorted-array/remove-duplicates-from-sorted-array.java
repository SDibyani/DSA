class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j =1;

        for ( int i=1; i < n ; i++){
            if ( nums[i] != nums[j-1]){      // for i==j-1 it will be i++ 
            // if not same then logic will be applied
                nums[j] = nums[i];
                j++;
            }

        }
        return j ; 
    }
}