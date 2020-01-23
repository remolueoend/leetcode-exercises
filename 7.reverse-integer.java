/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        double in = x >= 0 ? x : (-1) * (double)x;
        double res = 0;
        while(in != 0) {
           res = res * 10 + in % 10; 
           in = Math.floor(in / 10);
        }
        res = x >= 0 ? res : (-1) * res;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)res;
    }
}
// @lc code=end
