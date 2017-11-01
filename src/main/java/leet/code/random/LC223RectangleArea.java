/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC223RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //check if no overlap
        //A is left
        int total = getArea(A,B,C,D) + getArea(E,F,G,H);
        //if (E > C || F > D || G < A || B > H) return total;
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        
        //If overlap
        int overlap = 0;
        if(right > left && top > bottom)
             overlap = (right - left) * (top - bottom);
            
        return total - overlap;
    }
    
    public int getArea(int x1, int y1, int x2, int y2)
    {
        return Math.abs( (x2-x1) * (y2-y1) );
    }
}
