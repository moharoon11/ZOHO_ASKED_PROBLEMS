package batch1;

// the second approach is not working in gfg but the exact solution working in leetcode
public class LongestPallindromicSubstring {

    /**
     * brute approach
     * TIME COMPLEXITY: O(n^3)
     * SPACE COMPLEXITY: O(1)
     */
    public String longestPalindrome(String s) {

        if(s == null || s.length() == 1) return s;

        String maxStr = s.substring(0,1);
        int maxLen = 1;

        for(int i=0; i<s.length(); i++) {
            for(int j=i + maxLen; j<s.length(); j++) {
                if(j - i + 1> maxLen && isPallindrome(s, i, j)) {
                    maxLen = j - i + 1;
                    maxStr = s.substring(i, j+1);
                }
            }
        }

        return maxStr;
    }



    public boolean isPallindrome(String s, int start, int end) {

        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }


    // another approach
    // Time Complexity: O(n ^ 2)
    // Space Complexity: O(1)
    public String longestPalindrome1(String s) {

        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes (single character center)
            int len1 = expandAroundMiddle(s, i, i);
            // Check for even-length palindromes (between two characters)
            int len2 = expandAroundMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);

            // Update the start and end indices if a longer palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }


    static int expandAroundMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Length of the palindrome is (right - left - 1)
        return right - left - 1;
    }




}
