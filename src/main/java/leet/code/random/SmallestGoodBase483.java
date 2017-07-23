/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class SmallestGoodBase483 {
	/*	       
	 * 
	 *  bruteforce
	
	 public static String smallestGoodBase(String n) {
	        

 			long remainder = 0;
	        long len = Long.parseLong(n);
	    for(int i=2; i<Math.pow(len,1.0/2);i++)
	    {
	        long num = len;
	        while(num>i)
	        {
	            remainder = num%i;
	            num /= i;
	            if(remainder != 1) break;
	            if(num<i && num == 1)  return i+"";
	        }
	    }
	        return ""+(len-1);
	        
	        
	        
	    }*/
	 
	 public static long log(long base, long num){
	        return (long)((double)Math.log(num)/(double)Math.log(base));
	    }

	 
	 public static String smallestGoodBase(String n) 
	    {
	        Long num = Long.parseLong(n);
	        long lenOfBase = log(2,num)+1;
	        for(long baseLen = lenOfBase; baseLen>2;baseLen-- ){
	            long base = (long)Math.pow(num,1.0d/(double)(baseLen-1));
	            long sum =1;
	            long curr = 1;
	            int currBaseLen = 1;
	            while(currBaseLen<baseLen){
	                curr*=base;
	                sum+=curr;
	                currBaseLen++;
	            }
	            if(num==sum){
	                return ""+base;
	            }
	            
	                
	        }
	        return ""+(num-1);
	        
	        
	    }
	    
	 
	 public static void main(String[] args) {
		 String s = "15";
		System.out.println(smallestGoodBase(s));
	}
}
