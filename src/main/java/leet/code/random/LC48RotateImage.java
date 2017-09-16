/**
 * 
 */
package leet.code.random;

import java.util.LinkedList;

/**
 * @author manu
 *
 */
public class LC48RotateImage {

	 public void rotate(int[][] matrix) {
	        
	        int n = matrix.length;
	        for(int l=0; l < n/2 ; l++)
	        {
	           
	            //System.out.println();
	            for(int i = l ; i< n-l-1 ; i++)
	            {
	                 //System.out.print(matrix[l][i] + " ");
	                 //rotatebyK(matrix, l , i , (n-1/(l+1)));
	                rotate(matrix, l, i);
	            }
	        }
	        
	    }
	    public void rotatebyK(int [][] matrix, int i, int j, int k)
	    {
	        int n = matrix.length-1;
	        System.out.println(k);
	        swap (matrix, i, j, i+k, j+k);
	        //swap (matrix, i, j, i+k, j+k);
	        //swap (matrix, i, j, i+k, j+k);
	        //swap (matrix, i, j, i+k, j+k);
	         
	    }
	    
	    public void swap(int [][] matrix, int i , int j , int k, int l)
	    {
	        int temp = matrix[i][j];
	        matrix[i][j] = matrix[k][l];
	         matrix[k][l] = temp;
	    }
	    
	    private static void rotate(int[][] in, int i, int j) {

	        /*
			    int offset = in.length-1;

	            int temp = in[j][offset - i];
				in[j][offset - i] = in[i][j];
				int temp2 = in[offset - i][offset - j];
				in[offset - i][offset - j] = temp;
				temp = in[offset - j][offset - offset + i];
				in[offset - j][offset - offset + i] = temp2;
				in[i][j] = temp;

			*/
	    int o = in.length- 1;
	        /*
	  [ 5, 1, 9,11],
	  [ 2, 4, 8,10],
	  [13, 3, 6, 7],
	  [15,14,12,16]
	        3
	          [0][3] = [0][0] 
	          [3][3] = [0][3]
	          [3][0] = [3][3]
	          [0][0] = [3][0]
	          
	          o = 3
	          i =0
	          j = 1
	         
	          [0][1] = [2][0]   [i][j] = [o-j][i]
	          [2][0] = [3][2]   [o-j][i] = [o-i][o-j]
	          [3][2] = [1][3]   [o-i][o-j] = [j][o-i]
	          [1][3] = [0][1]   [j][o-i] = [i][j]
	          
	          
	          
	          
	          o = 2
	          i=1, j=1
	          [4][8] 
	          [3][6] 
	         
	         [1][1] = [2][1]  [i][j] = [o-j][i]
	         [2][1] = [2][2]  [o-j][i] = [o-i][o-i]
	         [2][2] = [1][2]  [o-i][o-j] = [j][o-i]
	         [1][2] = [1][1]  [j][o-i] = [i][j]
	   */
	            int temp = in[i][j];
	            in[i][j] = in[o-j][i];
	            in[o-j][i] = in[o-i][o-j];
	            in[o-i][o-j] = in[j][o-i];
	            in [j][o-i] = temp;
	            
	            

		}
	    
	    public void rotate2(int[][] matrix) 
	     {
	         int n = matrix.length;
	         int k = n -1;
	         rotateByK(matrix, k);
	         //return matrix;
	     }
	    
	    public void generateMatrix(LinkedList<Integer> list, int [][] out, int rs, int re, int cs, int ce) {
	        
	        //int [][] out = new int[n][n];
	        int rows = rs, rowe = re, cols = cs, cole = ce;
	        //int val =1;
	       // while(rows<=rowe && cols<=cole)
	       // {
	            //right
	            for(int j = cols; j<= cole && !list.isEmpty() ;j++)
	                out[rows][j] = list.removeFirst();
	            rows++;
	            //down
	            for(int i = rows; i<=rowe && !list.isEmpty();i++)
	                out[i][cole]=list.removeFirst();
	            cole--;
	            
	            //left
	            for(int j = cole; j>=cols && !list.isEmpty(); j--)
	                out[rowe][j] = list.removeFirst();
	            rowe--;
	            
	            //up
	            for(int i = rowe; i>=rows && !list.isEmpty(); i--)
	                out[i][cols] = list.removeFirst();
	            cols++;
	            
	            
	       // }
	        //return out;
	        
	    }
	 
	    public void rotateByK(int [][] matrix,int k)
	    {
	         LinkedList<Integer> list = new LinkedList<Integer>();
	        //if(matrix.length == 0) return list;
	        
	        int rowBegin = 0;
	        int rowEnd = matrix.length-1;
	        int colBegin = 0;
	        int colEnd = matrix[0].length-1;
	        
	       
	        while(rowBegin<=rowEnd && colBegin<=colEnd)
	        {
	            
	            int rs = rowBegin;
	            int re = rowEnd;
	            int cs =  colBegin;
	            int ce = colEnd;
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
	            
	               for(int z = 0; z< re-rs ; z++)
	               {
	                   list.addFirst(list.removeLast());
	               }
	            
	            generateMatrix(list, matrix, rs, re, cs, ce );
	        }
	     
	    }
	    /*
	    [[15,13,2,5],
	     [14,3,4,1],
	     [12,6,8,9],
	     [16,7,10,11]]
	    
	    [[15,13,2,5],
	     [14,8,6,1],
	     [12,4,3,9],
	     [16,7,10,11]]
	    */
}
