/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manu
 *
 */
public class LC54SpiralMatrix {

	 public List<Integer> spiralOrder(int[][] matrix) {
	       
	        List<Integer> list = new ArrayList<Integer>();
	        if(matrix.length == 0) return list;
	        
	        int rowBegin = 0;
	        int rowEnd = matrix.length-1;
	        int colBegin = 0;
	        int colEnd = matrix[0].length-1;
	        
	       
	        while(rowBegin<=rowEnd && colBegin<=colEnd)
	        {
	            
	            //right
	            for(int j = colBegin ; j<=colEnd; j++)
	                list.add(matrix[rowBegin][j]);
	            rowBegin++;
	            
	            if (rowBegin <= rowEnd) 
	            {
	            //down
	            for(int i = rowBegin; i<= rowEnd; i++)
	                list.add(matrix[i][colEnd]);
	            colEnd--;
	            
	            
	                //left
	                 for(int j = colEnd; j>=colBegin; j--)
	                    list.add(matrix[rowEnd][j]);
	                rowEnd--;
	           } 
	           
	            if (colBegin <= colEnd)
	            {
	                //up
	                for(int i = rowEnd; i>=rowBegin ;i--)
	                list.add(matrix[i][colBegin]);
	            colBegin++;
	            }
	            
	                
	        }
	        
	        return list;
	        
	    }
}
