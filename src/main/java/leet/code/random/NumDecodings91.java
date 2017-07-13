package leet.code.random;

import java.util.HashMap;

public class NumDecodings91 {

	   /*
	   brute force
	    public int numDecodings(String s) {
			
			
			// int doubleLen= numDecodingsHelper(s, 0, 1);
			HashMap<String, HashMap<Integer, Integer>> mem = new HashMap<String, HashMap<Integer, Integer>>();
			//int [][] memo = new int [s.length()+1][2];
			int single = numDecodingsHelperMem(s, 0, 0, mem) + numDecodingsHelperMem(s, 0, 1, mem);
			
			// if(doubleLen<0 && single <0) return -1;
			// if(doubleLen < 0) return single;
			// if(single < 0) return doubleLen;
			return single;

		}
		
		private int numDecodingsHelperMem(String str, int first, int second, HashMap<String, HashMap<Integer, Integer>> mem ) {

			
			if (first > str.length() || second > str.length()) {
				return 0;
			}


			if(mem.get(str.substring(second, str.length()))==null ||mem.get(str.substring(second, str.length())).get(second-first)==null ){
				
				int letter = 0;
				int prefix = 0;
				
				if (first < str.length() && second < str.length()) {
					letter = getValue(str.substring(first, second + 1));
					
				}
				HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
				if (letter > 26 || letter ==0 ) {
					mp.put(second-first, 0);
					mem.put(str.substring(second, str.length()), mp);
					return 0;
				}
				
				if(second>first){
					if(getValue(str.substring(first, first + 1))==0){
						mp.put(second-first, 0);
						mem.put(str.substring(second, str.length()), mp);
						return 0;
					}
				}

				if(second==str.length()-1){
					mp.put(second-first, 1);
					mem.put(str.substring(second, str.length()), mp);
					return 1;
				}	
				
				int left = numDecodingsHelper(str, second + 1, second + 1);
				int right = numDecodingsHelper(str, second + 1, second + 2);
				mp.put(second-first, left+right);
				mem.put(str.substring(second, str.length()),mp);
				
			}
				return mem.get(str.substring(second, str.length())).get(second-first);
		}

		private int numDecodingsHelper(String str, int first, int second) {

			
			if (first > str.length() || second > str.length()) {
				return 0;
			}

			int letter = 0;
			int prefix = 0;

			if (first < str.length() && second < str.length()) {
				letter = getValue(str.substring(first, second + 1));
				
			}

			if (letter > 26 || letter ==0 ) {
				return 0;
			}
			
			if(second>first){
				if(getValue(str.substring(first, first + 1))==0){
					return 0;
				}
			}

			if(second==str.length()-1){
				return 1;
			}	
			
			int left = numDecodingsHelper(str, second + 1, second + 1);
			int right = numDecodingsHelper(str, second + 1, second + 2);
			return left+right;
			

		}


		public int getValue(String str) {
			if(str.equalsIgnoreCase("")) return 0;
			return Integer.valueOf(str);
		}
	*/
	    
	    public int numDecodings(String s) {
	        if(s ==null || s.length()==0) return 0;
	        int n = s.length();
	        int [] mem = new int [n+1];
	        mem[0] = 1;
	        mem[1] = s.charAt(0)=='0' ? 0:1;
	        
	        for(int i = 2 ;i <=n; i++)
	        {
	            int first = Integer.valueOf(s.substring(i-1, i));
	            int second = Integer.valueOf(s.substring(i-2, i));
	            if(first>0 && first<10)
	            {
	                mem[i]+=mem[i-1];
	            }
	            if(second>=10 && second<=26)
	            {
	                mem[i]+=mem[i-2];
	            }
	        }
	        
	        return mem[n];
	    }

	public static void main(String[] args) {
		NumDecodings91 num = new NumDecodings91();
		System.out.println(num.numDecodings("123123"));

	}
}
