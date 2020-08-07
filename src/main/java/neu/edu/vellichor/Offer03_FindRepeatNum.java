package neu.edu.vellichor;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer03_FindRepeatNum {

    /**
     * 方法一：遍历数组
     * 由于只需要找出数组中任意一个重复的数字，因此遍历数组，遇到重复的数字即返回。为了判断一个数字是否重复遇到，使用集合存储已经遇到的数字，如果遇到的一个数字已经在集合中，则当前的数字是重复数字。
     *
     * 初始化集合为空集合，重复的数字 repeat = -1
     * 遍历数组中的每个元素：
     * 将该元素加入集合中，判断是否添加成功
     * 如果添加失败，说明该元素已经在集合中，因此该元素是重复元素，将该元素的值赋给 repeat，并结束遍历
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-b-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {

        //hash 表
        Set<Integer> set = new HashSet<Integer>();
        //默认返回-1若无重复值
        int res = -1;
        for (int num : nums){
            //判断如果添加失败则表示该数字为重复，设为返回值
            if (!set.add(num)){
                res = num;
                break;
            }
        }
        return res;
    }

    /**
     * 复杂性分析
     *
     * 时间复杂度：O(n)O(n)。
     * 遍历数组一遍。使用哈希集合（HashSet），添加元素的时间复杂度为 O(1)O(1)，故总的时间复杂度是 O(n)O(n)。
     * 空间复杂度：O(n)O(n)。不重复的每个元素都可能存入集合，因此占用 O(n)O(n) 额外空间。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-b-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param args
     */

    public static void main(String[] args) {
        int[] testNums = {1,2,3,4,5,5};//长度为6，值为1~5
        //长度为N，值为1~N-1
        Offer03_FindRepeatNum repeatNum = new Offer03_FindRepeatNum();
        System.out.println(repeatNum.findRepeatNumber(testNums));
        System.out.println(repeatNum.findRepeatNumS2(testNums));
        System.out.println(repeatNum.findRepeatNumS1(testNums));

    }


    /**
     * 使用临时数组
     * 这道题有个很明显的特点，就是数字的大小在0~n-1之间，
     * 所以使用上面两种方式肯定不是最好的选择。这里我们可以申请一个临时数组temp，
     * 因为nums元素中的每个元素的大小都在0~n-1之间，
     * 所以我们可以把nums中元素的值和临时数组temp建立映射关系，
     * 就是nums中元素的值是几，我们就把temp中对应的位置值加1，
     * 当temp某个位置的值大于1的时候，就表示出现了重复，我们直接返回即可
     *
     * 作者：sdwwld
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/java-de-4chong-jie-fa-by-sdwwld/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int findRepeatNumberS2(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];//建立与num同长度的临时数组 建立映射关系
        for (int i = 0; i < length; i++) {
            temp[nums[i]]++;
            //temp的index对应nums中的值
            //遍历temp，对于每个值的出现相应的将temp中以该值为index的数值+1
            if (temp[nums[i]] > 1)
                //若添加后该index的temp值大于1，代表重复值出现
                return nums[i];
        }
        return -1;
    }




    public int findRepeatNumS2(int[] nums){
        int[] temp = new int[nums.length];
        for (int num : nums){
            temp[num]++;
            if (temp[num]>1){
                return num;
            }
        }
        return -1;
    }


    public int findRepeatNumS1(int[] nums){
        int res  = -1;
        Set<Integer> set =  new HashSet<Integer>();
        for (int num : nums){
            if (!set.add(num)){
                res = num;
                break;
            }
        }
        return res;
    }


}
