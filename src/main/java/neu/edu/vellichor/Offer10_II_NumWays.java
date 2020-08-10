package neu.edu.vellichor;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer10_II_NumWays {

    /**
     * 当n等于1的时候，只需要跳一次即可，只有一种跳法，记f(1)=1
     *
     * 当n等于2的时候，可以先跳一级再跳一级，或者直接跳二级，共有2种跳法，记f(2)=2
     *
     * 当n等于3的时候，他可以从一级台阶上跳两步上来，也可以从二级台阶上跳一步上来，所以总共有f(3)=f(2)+f(1)；
     *
     * 同理当等于n的时候，总共有f(n)=f(n-1)+f(n-2)(这里n>2)种跳法。
     *
     * 作者：sdwwld
     * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/javaqing-wa-tiao-tai-jie-he-fei-bo-na-qi-shu-lie-t/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    /**
     * 解题思路：
     * 此类求 多少种可能性 的题目一般都有 递推性质 ，即 f(n)f(n) 和 f(n-1)f(n−1)…f(1)f(1) 之间是有联系的。
     *
     * 设跳上 nn 级台阶有 f(n)f(n) 种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 11 级或 22 级台阶。
     * 当为 11 级台阶： 剩 n-1n−1 个台阶，此情况共有 f(n-1)f(n−1) 种跳法；
     * 当为 22 级台阶： 剩 n-2n−2 个台阶，此情况共有 f(n-2)f(n−2) 种跳法。
     * f(n)f(n) 为以上两种情况之和，即 f(n)=f(n-1)+f(n-2)f(n)=f(n−1)+f(n−2) ，以上递推性质为斐波那契数列。本题可转化为 求斐波那契数列第 nn 项的值 ，与 面试题10- I. 斐波那契数列 等价，唯一的不同在于起始数字不同。
     * 青蛙跳台阶问题： f(0)=1f(0)=1 , f(1)=1f(1)=1 , f(2)=2f(2)=2 ；
     * 斐波那契数列问题： f(0)=0f(0)=0 , f(1)=1f(1)=1 , f(2)=1f(2)=1 。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */


    public int numWays(int n) {
        int step0 = 1, step1 = 1, stepSum;
        //step0 青蛙跳到第0个台阶方法为1种
        //step1 青蛙跳到第1个台阶方法为1种
        //stepSum 青蛙跳到第2个台阶方法为1+1种
        for(int i = 0; i < n; i++){
            stepSum = (step0 + step1) % 1000000007;
            step0 = step1;
            step1 = stepSum;
        }
        return step0;
    }

}
