/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC282ExpressionAddOperators {

	/*public List<String> addOperators(String num, int target) 
	{
		Set<String> fAns = new HashSet<String>();
		 List<String> out = addOperators(num);
		 for(String ans : out){
			 int targetVal = Integer.valueOf(ans.split(":")[0]);
			// System.out.println(ans.split(":")[1]);
			 if(target == targetVal)
			 {
				 fAns.add(ans.split(":")[1]);
			 }
			 
		 }
		 List<String> ok = new ArrayList<>(fAns);
		 return ok;
	}
	
public List<String> addOperators(String num) {
        
        List<String> out = new ArrayList<String>();
        
        if(num.length()==1)
        {
        	out.add(num + ":"+num);
        	return out;
        	
        }
        
        for(int i = 0 ; i < num.length(); i++)
        {
        	if(i+1 == num.length()){
        		return out;
        	}
            String left = num.substring(0, i+1);
            String right = num.substring(i+1, num.length());
            System.out.println(left);
            List<String> leftL = addOperators(left);
            List<String> rightL = addOperators(right);
            for(String l : leftL)
            {
                String [] vl = l.split(":");
                int lval = Integer.parseInt(vl[0]);
                for(String r: rightL)
                {
                    String [] vr = r.split(":");
                    int rval = Integer.parseInt(vr[0]);
                    
                    out.add(String.valueOf(lval + rval)+ ":" + vl[1] + "+" + vr[1]);
                    
                    out.add(String.valueOf(lval - rval)+ ":" + vl[1] + "-" + vr[1]);;
                    
                    out.add(String.valueOf(lval * rval)+ ":" + vl[1] + "*" + vr[1]);
                    
                    
                }
            }
            
        }
        
//        if(out.size()==0)
//        {
//          
//            
        
        return out;
    }
*/
	
	public List<String> addOperators(String num, int target) 
	{
       int n = num.length();
       List<String> list = new ArrayList<String>();
	   addOperatorsHelper(num, 0, n, 0l, target, "", list,0 );
        return list;
       
    }

    
    public void addOperatorsHelper(String num, int index, int length, Long currSum, int target, String buff, List<String> list, long mult)
    {
        
        if(index == length )
        {
            if(target == currSum)
            {
                list.add(buff);
            }
            return;
        }
        
        for(int i = index; i < length; i++)
        {
            String curr = num.substring(index,i+1);
            
            if(index !=i && curr.charAt(0)=='0') break;
            if(index == 0 )
            {
                addOperatorsHelper(num, i+1, length, currSum+Long.valueOf(curr), target, buff+curr, list, Long.valueOf(curr));
            }
            else
            {
                addOperatorsHelper(num, i+1, length, currSum+Long.valueOf(curr), target, buff+ "+" +curr,list, Long.valueOf(curr) );
                addOperatorsHelper(num, i+1, length, currSum-Long.valueOf(curr), target, buff+ "-" +curr, list,-Long.valueOf(curr) );
                addOperatorsHelper(num, i+1, length, currSum - mult +  mult*Long.valueOf(curr), target, buff+ "*" +curr, list, mult*Long.valueOf(curr) );
            }
        }
        
        
    }
	
	public static void main(String[] args) {
		System.out.println(new LC282ExpressionAddOperators().addOperators("105", 5));
	}
}
