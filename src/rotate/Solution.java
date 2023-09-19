package rotate;

public class Solution {
    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int[][] matrix1 = new int[row][row];
        for(int i = 0;i<row;i++){
            for(int j = 0 ;j<row;j++){
                matrix1[j][row-i-1]=matrix[i][j];
            }
        }
        for(int i = 0;i<row;i++){
            for(int j = 0 ;j<row;j++){
                System.out.println(matrix1[i][j]);
            }
        }

    }

    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        // 深拷贝 matrix -> tmp
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++)
            tmp[i] = matrix[i].clone();
        // 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix ={{5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}};
        rotate(matrix);
    }
}
