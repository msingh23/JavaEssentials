package leet.code.random;

public class LC59SpiralMatrixII {
    
    /*
    1  2  3   4  5
    16 17 18 19  6
    15 24 25 20  7
    14 23 22 21  8
    13 12 11 10  9
    */
    
    public int[][] generateMatrix(int n) {
        
        int out [][] = new int [n][n];
        
        int no = 1;
        for(int i = 0 ;i <=n/2 ; i++){
            no = fillRow(i, i, n-i-1, no, out );
            no = fillCol(n-i-1, i+1, n-i-1, no, out );
            no = fillRowRev(n-i-1, n-i-2, i, no, out );
            no = fillColRev(i, n-i-2, i+1, no, out );
        } 
        return out;
    }
    
    public int fillRow(int row, int colS, int colE, int no, int [][] out){
        while(row<out.length && row >=0 && colS >=0 && colE<out.length && colS<=colE){
            out[row][colS++] = no++;
        }
        return no;
    }
    
    public int fillRowRev(int row, int colS, int colE, int no, int [][] out){
        while(row<out.length && row >=0 && colE >=0 && colS<out.length && colS>=colE){
            out[row][colS--] = no++;
        }
        return no;
    }
    
    public int fillCol(int col , int rowS, int rowE, int no,int [][] out )
    {
        while(col>=0 && col <out.length && rowS>=0 &&  rowE <out.length && rowS<=rowE){
            out[rowS++][col] = no++;
        }
        return no;
    }
    
    public int fillColRev(int col , int rowS, int rowE, int no, int [][] out )
    {
        while(col>=0 && col <out.length && rowE>=0 &&  rowS <out.length && rowS>=rowE){
            out[rowS--][col] = no++;
        }
        return no;
    }
    
  public int[][] generateMatrix2(int n) {
        
        int [][] out = new int[n][n];
        int rows = 0, rowe = n-1, cols = 0, cole = n-1;
        int val =1;
        while(rows<=rowe && cols<=cole)
        {
            //right
            for(int j = cols; j<= cole ;j++)
                out[rows][j] = val++;
            rows++;
            //down
            for(int i = rows; i<=rowe;i++)
                out[i][cole]=val++;
            cole--;
            
            //left
            for(int j = cole; j>=cols; j--)
                out[rowe][j] = val++;
            rowe--;
            
            //up
            for(int i = rowe; i>=rows; i--)
                out[i][cols] = val++;
            cols++;
            
            
        }
        return out;
        
    }
}