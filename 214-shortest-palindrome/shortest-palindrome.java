class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int []lps = computeLPS(combined);
        int palindromeLength = lps[combined.length()-1];

        String suffixToAdd = s.substring(palindromeLength);
        String prefix = new StringBuilder(suffixToAdd).reverse().toString();

        return prefix + s;

        
    }

    private int[] computeLPS(String str){
        int[] lps= new int[str.length()];
        int len=0;

        for(int i=1; i< str.length(); i++){
            while(len > 0 && str.charAt(i) != str.charAt(len)){
                len = lps[len-1];
            }
            if(str.charAt(i) == str.charAt(len)){
                len++;
                lps[i]=len;
            }
        }
        return lps;
    }
}