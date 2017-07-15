package leet.code.random;

public class SpiralMatrixII59 {
    
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
}