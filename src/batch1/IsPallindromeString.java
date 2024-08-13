package batch1;

public class IsPallindromeString {

    int isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return 0;
            }

            start++;
            end--;
        }

        return 1;
    }

}
