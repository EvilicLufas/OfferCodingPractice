package neu.edu.vellichor;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();//维护入队列
        stack2 = new Stack<>();//维护出队列
    }

    public void appendTail(int value) {
        stack1.push(value);//加队列直接加入stack1中
    }

    public int deleteHead() {
        if(!stack2.isEmpty()){
            //若stack2不为空, 则stack2已被stack1反序插值（符合Queue先进先出的规律）
            return stack2.pop();
        }else {
            //若stack2为空，则将stack1中值（先进后出）全部插入stack2中
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
//            return stack2.isEmpty() ? -1 : stack2.pop();
            if(stack2.isEmpty()){
                //队列中没有元素，delete操作返回-1
                return -1;
            }else {
                return stack2.pop();
            }
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */


class CQueue2 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);

    }

    public int deleteHead() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()){
                return -1;
            }
            else {
                return stack2.pop();
            }
        }
    }
}


public class Offer09_CQueue {
/**
 * 方法一：双栈
 * 思路和算法
 *
 * 维护两个栈，第一个栈支持插入操作，第二个栈支持删除操作。
 *
 * 根据栈先进后出的特性，我们每次往第一个栈里插入元素后，
 * 第一个栈的底部元素是最后插入的元素，第一个栈的顶部元素是下一个待删除的元素。
 * 为了维护队列先进先出的特性，我们引入第二个栈，用第二个栈维护待删除的元素，
 * 在执行删除操作的时候我们首先看下第二个栈是否为空。
 * 如果为空，我们将第一个栈里的元素一个个弹出插入到第二个栈里，
 * 这样第二个栈里元素的顺序就是待删除的元素的顺序，
 * 要执行删除操作的时候我们直接弹出第二个栈的元素返回即可。
 *
 * 成员变量
 *
 * 维护两个栈 stack1 和 stack2，其中 stack1 支持插入操作，stack2 支持删除操作
 * 构造方法
 *
 * 初始化 stack1 和 stack2 为空
 * 插入元素
 *
 * 插入元素对应方法 appendTail
 *
 * stack1 直接插入元素
 * 删除元素
 *
 * 删除元素对应方法 deleteHead
 *
 * 如果 stack2 为空，则将 stack1 里的所有元素弹出插入到 stack2 里
 * 如果 stack2 仍为空，则返回 -1，否则从 stack2 弹出一个元素并返回
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


/**
 * Stack先进后出， Queue先进先出， 维护两个栈，第一个栈支持插入操作，第二个栈支持删除操作。
 * 删除时，将第一个stack的元素依次加入到第二个stack中，则第二个stack中就是删除的顺序
 */





}
