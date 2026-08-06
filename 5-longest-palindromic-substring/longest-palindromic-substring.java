public class Solution {

    
    public static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    
    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            
            String odd = expandFromCenter(s, i, i);
            if (odd.length() > longest.length()) {
                longest = odd;
            }

            
            String even = expandFromCenter(s, i, i + 1);
            if (even.length() > longest.length()) {
                longest = even;
            }
        }

        return longest;
    }

    
    public static void main(String[] args) {
        String input = "babad";
        System.out.println("Longest palindrome in '" + input + "': " + longestPalindrome(input));

        input = "cbbd";
        System.out.println("Longest palindrome in '" + input + "': " + longestPalindrome(input));
    }
}
