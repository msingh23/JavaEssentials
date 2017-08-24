/**
 * 
 */
package leet.code.random;

import java.util.HashSet;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC36ValidSudoku {

 /*
    
    0       1       2
    0       0       0
  
    0 1 2   3 4 5   6 7 8  
    1 2 3   . . .   8 . 1
    0 8 .   4 6 8   3 0 5
    
    0       1       2
    1       1       1
    
    1 . 3   7 . .   6 . .  
    8 . .   . . .   8 . 1
    0 8 .   4 6 8   3 0 5
    */
    
    public boolean isValidSudoku(char[][] board) {
        
        for(int r = 0 ; r < 9 ; r ++){
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();
            for(int c =0 ; c<9 ; c++){
                
                if(board[r][c] !='.' && !row.add(board[r][c]))
                {
                    return false;
                }
                
                if(board[c][r]!='.' && !col.add(board[c][r])){
                    return false;
                }
                          
                int cubeCol = ((r % 3)*3)+ (c % 3);
                int cubeRow = ( (r / 3)*3) + (c/3 );
                
                if(board[cubeRow][cubeCol]!='.' && !cube.add(board[cubeRow][cubeCol]))
                {
                    return false;
                }
                
                
            }
            
        }
        return true;
    }
}
