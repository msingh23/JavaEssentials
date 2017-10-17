/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC661ImageSmoother {
	public int[][] imageSmoother(int[][] M) {
        int r = M.length;
        int c = M[0].length;
        int dir [][] = new int[][]{ {0, -1},{-1, -1},{-1, 0},{-1, +1},{0, +1},{+1,+1 },{+1,0},{+1, -1} };
        int [][] smooth = new int [r][c];
        
        for(int i = 0;i<r;i++)
        {
            for(int j =0 ;j <c; j++)
            {
                
                int sum = M[i][j];
                int count = 1;
                
                for(int [] d : dir)
                {
                    if(d[0]+i >=0 && d[0]+i <r && d[1] + j >=0 && d[1]+j < c)
                    {
                        sum = sum+M[d[0]+i][d[1] + j];
                        count++;
                    }
                }
                smooth[i][j] = sum/count;
                
            }
        }
        return smooth;
        
    }
}
