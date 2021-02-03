package com.markedline.textworker.util;

public class PalindromeFinder {

    private String getPalindrome(String str, int low, int high) {
        return str.substring(low, high + 1);
    }

    public String findLongestPalindrome(String str) {
        int maxLength = 1;

        int start = 0;
        int len = str.length();

        int low, high;

        for (int i = 1; i < len; ++i) {
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && Character.toLowerCase(str.charAt(low)) ==
                    Character.toLowerCase(str.charAt(high))) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }


            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && Character.toLowerCase(str.charAt(low)) ==
                    Character.toLowerCase(str.charAt(high))) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        return getPalindrome(str, start, start + maxLength - 1);
    }
}
