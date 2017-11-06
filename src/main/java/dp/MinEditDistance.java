package dp;

/*
    Question:
 */

import java.util.Scanner;

//http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
public class MinEditDistance {

    public static void main(String[] args) {
        MinEditDistance med = new MinEditDistance();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the two strings");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        med.compute(str1, str2);
    }

    private void compute(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int dp[][] = new int[l1][l2];



        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = editRequired(i, j, s1, s2);
                } else {
                    dp[i][j] = editRequired(i, j, s1, s2) + min(i, j, dp);
                }
            }
        }
        System.out.println("Min steps to convert string \'" + s2 + "\' to \'" + s1 + "\' are: " + dp[l1-1][l2-1]);
    }

    private int editRequired(int i, int j, String s1, String s2) {
        if (i >= s1.length() || j >= s2.length()) {
            return 1;
        }
        return s1.charAt(i) == s2.charAt(j) ? 0 : 1;
    }

    private int min(int i, int j, int dp[][]) {
        if (i == 0) {
            return dp[i][j-1];
        } else if (j == 0) {
            return dp[i-1][j];
        } else {
            return Integer.min(Integer.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
        }
    }

}
