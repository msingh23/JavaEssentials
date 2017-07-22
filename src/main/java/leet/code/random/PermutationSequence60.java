/**
 * 
 */
package leet.code.random;

import java.util.LinkedList;

/**
 * @author manu
 *
 */
public class PermutationSequence60 {

	/*
	 * O(n!)
	public class Perm {
		int kth = 0;
		String out = "";

	}

	public String getPermutation(int n, int k) {
		Perm perm = new Perm();
		StringBuffer buff = new StringBuffer();
		Set<Integer> set = new HashSet<Integer>();
		getPermutationHelper(perm, 0, n, k, buff, set);
		return perm.out;
	}

	private void getPermutationHelper(Perm perm, int start, int n, int k, StringBuffer buff, Set<Integer> set) {
		// TODO Auto-generated method stub

		if (buff.length() == n) {
			perm.out = buff.toString();
			perm.kth++;
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!set.contains(i)) {
				set.add(i);
				buff.append(i);
				getPermutationHelper(perm, i, n, k, buff, set);
				if (perm.kth == k) {
					return;
				}
				buff.deleteCharAt(buff.length() - 1);
				set.remove(i);
			}

		}

	}
*/
	

    public String getPermutation(int n, int k) {
        
        if (n==1){
            return new String()+k;
        }
        
        int [] fact = new int[n+1];
        fact[0]=1;
        int sum =1;
        for(int i = 1;i <= n; i++)
        {
            sum *=i;
            fact[i] =sum;
        }
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i =1;i<n+1;i++)
        {
            list.add(i);
        }
        
        StringBuffer buff = new StringBuffer();
        int i =1;
        k--;
        while(i<=n)
        {
         
            int index = k/fact[n-i];
            buff.append(list.remove(index));
            //k -= (index * Math.fact[n-i]);
            k%=fact[n-i];
            i++;
            
            
        }
             return buff.toString();   
    }
	public static void main(String[] args) {
		PermutationSequence60 perm = new PermutationSequence60();
		System.out.println(perm.getPermutation(3, 6));
	}

}
