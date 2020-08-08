package neu.edu.vellichor;

/*
 *输入一个链表的头节点，
 * 从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 
限制：

0 <= 链表长度 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}


public class Offer06_ReversePrintLinkedList {


    /**
     * 解题思路：
     * 链表特点： 只能从前至后访问每个节点。
     * 题目要求： 倒序输出节点值。
     * 这种 先入后出 的需求可以借助 栈 来实现。
     *
     * 算法流程：
     * 入栈： 遍历链表，将各节点值 push 入栈。（Python​ 使用 append() 方法，​Java​借助 LinkedList 的addLast()方法）。
     * 出栈： 将各节点值 pop 出栈，存储于数组并返回。（Python​ 直接返回 stack 的倒序列表，Java ​新建一个数组，通过 popLast() 方法将各元素存入数组，实现倒序输出）。
     * 复杂度分析：
     * 时间复杂度 O(N)O(N)： 入栈和出栈共使用 O(N)O(N) 时间。
     * 空间复杂度 O(N)O(N)： 辅助栈 stack 和数组 res 共使用 O(N)O(N) 的额外空间。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    /**
     * LinkedList数据结构是一种双向的链式结构，
     * 每一个对象除了数据本身外，还有两个引用，
     * 分别指向前一个元素和后一个元素。
     *
     * 栈的定义栈(stack)是限制仅在线性表的一端进行插入和删除运算。
     * (1)通常称插入、删除的这一端为栈顶(Top)，另一端称为栈底(Bottom)。
     * (2)当线性表中没有元素时称为空栈。
     * (3)栈为后进先出(Last In First Out)的线性表，简称为LIFO表。
     * 栈的修改是按后进先出的原则进行。每次删除的总是当前栈中"最新"的元素，
     * 即最后进栈的元素，而最先插入的是被放在栈的底部，要到最后才能删除。
     */
    public int[] reversePrint(ListNode head) {
        //从尾到头 先入后出 使用Stack来实现
        LinkedList<Integer> stack = new LinkedList<Integer>();
        //遍历链表，将各节点push入栈
        while(head!=null){
            stack.addLast(head.val);
            head = head.next;
        }
        //建立返回的数组
        int[] res = new int[stack.size()];
        //将各节点值pop出栈，存储于数组并返回
        for (int i=0;i<res.length; i++){
            res[i] = stack.removeLast();
        }
        return res;
    }

    private ArrayList<Integer> tmp = new ArrayList<Integer>();

    private void recur(ListNode head){
        if (head==null) return;
        recur(head.next);
        tmp.add(head.val);
    }

    public int[] reversePrintLinkedListS2(ListNode head){
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i=0; i<res.length; i++){
            res[i] = tmp.size();
        }
        return res;
    }

    /**
     * 栈的特点是后进先出，即最后压入栈的元素最先弹出。考虑到栈的这一特点，使用栈将链表元素顺序倒置。从链表的头节点开始，依次将每个节点压入栈内，然后依次弹出栈内的元素并存储到数组中。
     *
     * 创建一个栈，用于存储链表的节点
     * 创建一个指针，初始时指向链表的头节点
     * 当指针指向的元素非空时，重复下列操作：
     * 将指针指向的节点压入栈内
     * 将指针移到当前节点的下一个节点
     * 获得栈的大小 size，创建一个数组 print，其大小为 size
     * 创建下标并初始化 index = 0
     * 重复 size 次下列操作：
     * 从栈内弹出一个节点，将该节点的值存到 print[index]
     * 将 index 的值加 1
     * 返回 print
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public int[] reversePrintS3(ListNode head){
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while(temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i=0;i<size;i++){
            print[i] = stack.pop().val;
        }
        return print;
    }

//
//    public int[] reversePrintLinkedList(ListNode head){
//
//        LinkedList<Integer> stack = new LinkedList<Integer>();
//        while(head!=null){
//            stack.addLast(head.val);
//            head = head.next;
//        }
//        int[] res = new int[stack.size()];
//        for (int i=0;i<res.length;i++){
//            res[i] = stack.removeLast();
//        }
//        return res;
//    }

    public static void main(String[] args){
        Offer06_ReversePrintLinkedList reversePrintLinkedList = new Offer06_ReversePrintLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(Arrays.toString(reversePrintLinkedList.reversePrint(node1)));
    }

}
