/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    private int getVal(char character) {
        switch(character) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("invalid character " + character);
        }
    }
    public int romanToInt(String s) {
       int res = 0;
       int i;
       for (i = 0; i < s.length() - 1; i++) {
           int c = getVal(s.charAt(i));
           int n = getVal(s.charAt(i + 1));
           res += (c >= n ? c : (-1) * c);
       }
       res += getVal(s.charAt(i));
       
       return res;
    }
}
// @lc code=end

