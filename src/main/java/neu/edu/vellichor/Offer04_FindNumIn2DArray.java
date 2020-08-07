package neu.edu.vellichor;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *  
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer04_FindNumIn2DArray {

    /**
     * 线性查找
     * 由于给定的二维数组具备每行从左到右递增以及每列从上到下递增的特点，
     * 当访问到一个元素时，可以排除数组中的部分元素。
     *
     * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
     * 如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
     *
     * 可以证明这种方法不会错过目标值。如果当前元素大于目标值，
     * 说明当前元素的下边的所有元素都一定大于目标值，因此往下查找不可能找到目标值，
     * 往左查找可能找到目标值。如果当前元素小于目标值，
     * 说明当前元素的左边的所有元素都一定小于目标值，因此往左查找不可能找到目标值，
     * 往下查找可能找到目标值。
     *
     * 若数组为空，返回 false
     * 初始化行下标为 0，列下标为二维数组的列数减 1
     * 重复下列步骤，直到行下标或列下标超出边界
     * 获得当前下标位置的元素 num
     * 如果 num 和 target 相等，返回 true
     * 如果 num 大于 target，列下标减 1
     * 如果 num 小于 target，行下标加 1
     * 循环体执行完毕仍未找到元素等于 target ，说明不存在这样的元素，返回 false`
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-b-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
            //若数组为空，返回 false
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        //初始化行下标为 0，列下标为二维数组的列数减 1

        //重复下列步骤，直到行下标或列下标超出边界
        while (row < rows && column >= 0) {

            int num = matrix[row][column];
            if (num == target) {

                return true;
            } else if (num > target) {
//如果当前元素大于目标值，说明当前元素的下边的所有元素都一定大于目标值，
// 因此往下查找不可能找到目标值，往左查找可能找到目标值。列下标-1
                column--;
            } else {
                row++;
//如果当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，
// 因此往左查找不可能找到目标值，往下查找可能找到目标值。行下标+1
            }
        }
        return false;
    }


    public boolean findNumIn2DMatrix(int[][] matrix, int target ){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            System.out.println("matrix empty");
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        int indexRow = 0;//最上一行
        int indexColumn = columns-1;//最右边列

        while(indexRow < rows && indexColumn >= 0){

            int num = matrix[indexRow][indexColumn];
            if (num == target){
                return true;
            }else if(num > target){
                indexColumn--;
            }else {
                indexRow ++;
            }


        }
        return false;
    }


    public boolean findNumberIn2DArrayS(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0, column = columns - 1; //从矩阵右上角开始

        while (row<rows && column>=0){
            int num = matrix[row][column];
            if(num == target){
                return true;
            }else if(num > target){
                column--;
                //如果当前数比target大，则该数所在列的该数之下的数字也都比target大
                //选择直接右移列数，减少列数，朝左取数
            }else{
                row++;
                //如果num比target小，则该列在num上边的数都比target小
                //选择下移行数，加行数，朝下取
            }

        }
        return false;
    }


    /**
     * 复杂度分析
     *
     * 时间复杂度：O(n+m)O(n+m)。访问到的下标的行最多增加 n 次，列最多减少 m 次，因此循环体最多执行 n + m 次。
     * 空间复杂度：O(1)O(1)。
     *
     */

    public static void main(String[] args) {
        Offer04_FindNumIn2DArray result = new Offer04_FindNumIn2DArray();
        int[][] matrix = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        System.out.println(result.findNumberIn2DArray(matrix,5));


    }
}
