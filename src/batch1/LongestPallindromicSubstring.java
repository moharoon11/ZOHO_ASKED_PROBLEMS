package batch1;

public class LongestPallindromicSubstring {

    /**
     * brute approach
     * TIME COMPLEXITY: O(n^2)
     * SPACE COMPLEXITY: O(1)
     */
    static String longestPalin(String s){

        int max = Integer.MIN_VALUE;
        String lpal = "";
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                String word = s.substring(i, j+1);
                if(isPalindrome(word)) {
                    if(word.length() > max) {
                        max = word.length();
                        lpal = word;
                    }
                }
            }
        }


        return lpal;
    }

    public static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while(left <= right) {
            if(word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }

        return true;
    }



}
