/**
 * 
 */
package ctci.chap5;

/**
 * @author manu
 *  0 1 2 3 4 5 6 7
 * [0 0 0 0 0 0 0 0] [0 0 0 0 0 0 0 0]
 * [0 0 0 0 0 0 0 0] [0 0 0 0 0 0 0 0]
 * [0 0 0 0 0 0 0 0] [0 0 0 0 0 0 0 0]
 *
 */

public class DrawLine {

	public void drawLine(byte [] screen, int w, int x1, int x2, int y)
	{
		int start_offset = x1 % 8;
		int end_offset = x2 % 8;
		int start_byte = x1 / 8;
		int end_byte = x2 / 8;
		
		for(int j = start_byte +1;j< end_byte;j++ ){
			screen[((w/8) *y) + j] = (byte) 0xff;
		}
		
		byte mask_start =  (byte) (0xff>>start_offset);
		byte mask_end = (byte)~(0xff>>end_offset+1);
		
		if(start_byte == start_byte)
		{
			screen[((w/8) *y) + start_byte] = (byte) (mask_start & mask_end);
		}else
		{
			screen[(w/8)*y+start_byte] = (byte) mask_start;
			screen[(w/8)*y+end_byte] = (byte) mask_end;
			
		}
		
	}
	
}
