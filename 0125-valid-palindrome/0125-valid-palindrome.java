// class Solution {
//     public boolean isPalindrome(String s) {
//         int left =0; int right = s.length()-1;


//     while(left < right){
//         while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
//             left++;
//         }
//         while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
//             right--;
//         }
//         if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
//             return false;
//         }
//         left++;
//         right--;
        
//         }
//         return true;
//     }
// }





class Solution {
    public boolean isPalindrome(String s) {
      s = s.toLowerCase();
      s= s.replaceAll("[^a-z0-9]","");
      int n = s.length();


      for(int i=0; i<n/2; i++){
        if (s.charAt(i)  != s.charAt(n-1-i))
        return false;
      }
      return true;


    
    }
}