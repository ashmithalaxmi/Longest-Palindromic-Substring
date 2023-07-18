import java.util.Scanner;

public class LongestPalindromicSubstring {
        public static String longestPalindrome(String str) {
            int n = str.length();
            boolean[][] dp = new boolean[n][n];
            int start = 0;
            int maxLen = 1;
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }
            for (int i = 0; i < n-1; i++) {
                if (str.charAt(i) == str.charAt(i+1)) {
                    dp[i][i+1] = true;
                    start = i;
                    maxLen = 2;
                }
            }
            for (int len = 3; len <= n; len++) {
                for (int i = 0; i < n-len+1; i++) {
                    int j = i+len-1;
                    if (str.charAt(i) == str.charAt(j) && dp[i+1][j-1]) {
                        dp[i][j] = true;
                        start = i;
                        maxLen = len;
                    }
                }
            }
            return str.substring(start, start+maxLen);
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            System.out.println(longestPalindrome(str));
        }
}


