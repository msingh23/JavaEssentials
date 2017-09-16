/**
 * 
 */
package leet.code.random;

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
}
