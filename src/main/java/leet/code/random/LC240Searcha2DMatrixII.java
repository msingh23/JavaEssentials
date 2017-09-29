/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC240Searcha2DMatrixII {

public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length-1;
        if(rows < 0) return false;
        int cols = matrix[0].length-1;
        
        int row = 0;
        int col = cols;
        while(row <= rows && col>=0 )
        {
            if(matrix[row][col] == target)
                return true;
            if(target>matrix[row][col])
                row++;
            else if(target < matrix[row][col])
                col--;
        }
        
        return false;
    }
}
