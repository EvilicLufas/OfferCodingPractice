package neu.edu.vellichor;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 *输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 基础知识
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 * 中序遍历：左子树---> 根结点 ---> 右子树
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 * 层次遍历：只需按层次遍历即可
 *
 * 例如：
 * 前序遍历：1 2 4 7 3 5 6 8
 * 中序遍历：4 7 2 1 5 3 8 6
 * 后序遍历：7 4 2 5 8 6 3 1
 * 层次遍历：1 2 3 4 5 6 7 8
 *
 * 前序遍历首先访问根结点然后遍历左子树，最后遍历右子树。在遍历左、右子树时，仍然先访问根结点，然后遍历左子树，最后遍历右子树。
 * 中序遍历（LDR）是二叉树遍历的一种，也叫做中根遍历、中序周游。在二叉树中，中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。
 * 二叉树的什么什么遍历，其实也是很好记的，就是根在呢就是什么遍历，在前就是前遍历，中就是中序遍历，后就是后序遍历，其他的是层次遍历。
 *
 * 解题：
 * 根据前序遍历，可以知道根节点（1），
 * 根据中序遍历可以知道左子树（4,7,2）和右子树（5,3,8,6）。
 * 找到左右子树之后，我们可以以相同的方式找到左右子树，
 * 也就是说这是一个递归的过程。根>左>右。
 */



public class Offer07_BuildTree {

    //先序遍历的第一个节点就是root
    // 在中序遍历中通过root区分哪些是左子树，哪些是右子树
    //左右子树，递归

    HashMap<Integer, Integer> dic = new HashMap<>();
    //标记中序遍历
    int[] po;//保留的先序遍历

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i=0;i<inorder.length;i++){
            dic.put(inorder[i],i);
        }
        return recur(0,0,inorder.length-1);
    }

    /**
     *
     * @param pre_root 先序遍历的索引
     * @param in_left  中序遍历的索引
     * @param in_right 中序遍历的索引
     * @return
     */
    TreeNode recur(int pre_root, int in_left, int in_right){

        if (in_left > in_right) return null;
        //相等就是自己

        TreeNode root = new TreeNode(po[pre_root]);
        int i = dic.get(po[pre_root]);
        //有了先序，根据先序，在中序中获取当前根的索引

        root.left = recur(pre_root+1,in_left,i-1);
        //左子树的root 就是 左子树前序遍历的第一个，就是+1
        //左边界就是left,有边界就是idx-1
        // 前序遍历特点： 节点按照 [ 根节点 | 左子树 | 右子树 ]

        root.right = recur(pre_root+i-in_left+1,i+1,in_right);

        //中序遍历特点： 节点按照 [ 左子树 | 根节点 | 右子树 ]

        return root;
    }

}
