class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
       int maxLen =0;
       HashSet<Character> set = new HashSet<>();
       int left =0;

       for ( int right =0; right < n ; right++){
        while(set.contains(s.charAt(right))){
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(right));
        maxLen = Math.max(maxLen , right-left+1);
       }
       return maxLen;
        
    }
}




// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int left = 0; 
//         int maxLen = 0;

      
//         int[] lastSeen = new int[256]; 
//         Arrays.fill(lastSeen, -1);

//         for (int right = 0; right < s.length(); right++) {
//             char ch = s.charAt(right);

         
//             if (lastSeen[ch] >= left) {
//                 left = lastSeen[ch] + 1;
//             }

           
//             lastSeen[ch] = right;

          
//             maxLen = Math.max(maxLen, right - left + 1);
//         }

//         return maxLen;
        
//     }
// }