package neu.edu.vellichor;


/*
  请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

   

  示例 1：

  输入：s = "We are happy."
  输出："We%20are%20happy."
   

  限制：

  0 <= s 的长度 <= 10000

  来源：力扣（LeetCode）
  链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 */


/**
 * 解题思路：
 * 在 Python 和 Java 等语言中，字符串都被设计成不可变的类型，
 * 即无法直接修改字符串的某一位字符，需要新建一个字符串实现。
 *
 * Python 解法流程：
 *
 * 初始化一个 list ，记为 res ；
 * 遍历列表 s 中的每个字符 c ：
 * 当 c 为空格时：向 res 后添加字符串 "%20"；
 * 当 c 不为空格时：向 res 后添加字符 c ；
 * 将列表 res 转化为字符串并返回。
 *
 *
 * Java 解法流程：
 *
 * 初始化一个 StringBuilder ，记为 res ；
 * 遍历字符串 s 中的每个字符 c ：
 * 当 c 为空格时：向 res 后添加字符串 "%20"；
 * 当 c 不为空格时：向 res 后添加字符 c ；
 * 将 res 转化为 String 类型并返回。
 * 复杂度分析：
 * 时间复杂度 O(N)O(N) ： 遍历使用 O(N)O(N) ，每轮添加（修改）字符操作使用 O(1)O(1) ；
 * 空间复杂度 O(N)O(N) ： Python 新建的 list 和 Java 新建的 StringBuilder 都使用了线性大小的额外空间。
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-ji-jian-qing-xi-tu-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer05_StringReplace {
    public String replaceString(String s ){
        StringBuilder res = new StringBuilder();
        //StringBuilder建立一个新的String
//        for (Character c : s.toCharArray()){
        for (char c : s.toCharArray()){
            //Character是char的包装类,就像Integer和int
            //将String转化为Char,遍历其中每一个character
            if (c==' '){
                //若该character为空格,则像stringBuilder添加"%20"
                res.append("%20");
            }else {
                //若该character不为空格，则向stringBuilder添加原有字符
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args){

        Offer05_StringReplace result = new Offer05_StringReplace();
        String string = "Hello Vilic Kyst";
        System.out.println(result.replaceString(string));

    }
}
