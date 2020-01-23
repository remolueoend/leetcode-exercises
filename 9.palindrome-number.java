/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int rest = x;
        int rev = 0;
        while(rest != 0) {
            rev = rev * 10 + rest % 10;
            rest = rest / 10;
        }
        
        return rev == x;
    }
}
// @lc code=end

