/**
 * 
 */
package ctci.chap5;

/**
 * @author manu
 *
 */
public class NextNumber {

	public int[] getNext(int no) {
		int[] out = new int[2];
		out[0] = getNextSmaller(no);
		out[1] = getNextLarger(no);
		return out;
	}

	
	
	/*
	 * 
	 *  example
	 *  32 16 8 4 2 1
	 *  1   0 1 1 0 0 = 44
	 *  1   0 1 0 1 0 = 42
	 *  
	 *  32 16 8 4 2 1
	 * 		1 1	0 1	1 = 27
	 *      1 0 1 1 1 = 23
	 *      
	 *   logic is find the first 1 succeded by a zero
	 * c0 = the bit position of the zero after the first 1
	 * c1 = the bit position of the one succeded by first 0  
	 * 
	 * while( n >0) 
	 * 	if(1 & n) ==1) 
	 * 		c1++
	 * 		n = n >>1
	 * 
	 * while( n >0) 
	 * 	if(1 & n) !=1) 
	 * 		c0++
	 * 		n = n >>1
	 * 
	 * if(c0 ==0 || c1 == 31)
	 * 		return -1;
	 * 
	 *  p is the bit which is to be switched 
	 *  p = c0 + c1
	 *    n = n & (~0<<(p+1))  make all bits zero from p
	 *    mask = ((1<<(c1+1)) -1)  mask for the right of p (p1+1) 1's followed with (c0-1) 0's 
	 *     n = n | mask<< (c0-1)
	 *    
	 * 
	 */
			
			
	private int getNextSmaller(int no) {
		int n = no;
		int c0 = 0;
		int c1 = 0;
		while((n & 1)==1){
			c1++;
			n = n>>1;
		}
		
		while(n>0 && (n & 1) ==0){
			c0++;
			n = n>>1;
		}
		
		int p = c0+c1;
		if(c0 ==0 | p ==31)
		{
			return -1;
		}
		
		int moveP = (~0)<<(p+1);
		no = no & (moveP);
		int mask = ((1<<(c1+1)) -1);
		mask = mask << (c0-1);
		no = no | mask;
		return no;
	}

	/*
	 * 
	 * example
	 *  32 16 8 4 2 1
	 *  1   0 1 1 0 0 = 44
	 *  1   1 0 0 0 1 = 49
	 *  
	 *  32 16 8 4 2 1
	 * 		1 1	0 1	1 = 27
	 *      1 1 1 0 1 = 29
	 * 
	 * find the non trailing 0 
	 * c0 = the last zero of trailing zero
	 * c1 = the first one after the first non tailing zero
	 * 
	 * while(n>0 && n&1==0)
	 * 		c0++
	 * 		n= n >>1;
	 * 
	 * while(n&1 == 1)
	 * 		c1++
	 * 		n=n>>1
	 * 
	 * p is the bit of the first non tailing zero
	 * p = c0 + c1
	 * 
	 *  n &=(~0<<p) moke all bits 0 after first non trailing 0 and make first non trailing zero 1
	 *  mask = (1<<c1)-1
	 *  n = n | mask
	 *  
	 * 
	 * 
	 */
	
	private int getNextLarger(int no) {
		int n = no;
		int c0 = 0;
		int c1 = 0;
		while(n>0 && (n & 1) ==0){
			c0++;
			n = n>>1;
		}
		while((n & 1)==1){
			c1++;
			n = n>>1;
		}
		
		
		int p = c0 + c1;
		if( p ==31)
		{
			return -1;
		}
		n = no | (1<<p);
		n = n & (~0<<p);
		int mask = (1<<c1-1)-1;
		n |= mask;
		return n;

	}
	
	
}
