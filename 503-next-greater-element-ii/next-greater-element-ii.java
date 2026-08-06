class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int [nums.length];

        for(int i= 2* nums.length-1; i >=0; i--){
            int idx = i % nums.length;

            while(!s.isEmpty() && nums[s.peek()] <= nums[idx]){
                s.pop();
            }
            if(s.isEmpty()){
                nxtGreater[idx] = -1;
            } else {
                nxtGreater[idx]= nums[s.peek()];
            }
            s.push(idx);
        }
        
            return nxtGreater;
      
       
        
    }
}