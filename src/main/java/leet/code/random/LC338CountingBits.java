/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC338CountingBits {
	public int[] countBits(int num) {
        if(num<1) return new int []{0};
        int [] mem = new int [num+1];
        mem[0]= 0;
        mem[1] = 1;
        int i = 2;
        while(i<=num)
        {
            mem[i] = mem[i/2];
            if(i%2!=0)
                mem[i]++;
            i++;
        }
        return mem;
    }
}
