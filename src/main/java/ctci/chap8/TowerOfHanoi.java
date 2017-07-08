package ctci.chap8;

import java.util.Stack;

public class TowerOfHanoi {

	
	/*
	 * 
	 *          
	 *         
	 *  (3,a,c,b )      
	 * 2(2,a,b,c )     (2,b,a,c)
	 * 3(1,a,c,b)      (1,b,a,c ) 
	 * 4(0,a,b,c )     
	 *  (0,a,b,c) 
	 * 			
	 * 
	 *  
	 *  3       1
	 *  4       2 
	 *  A   B   C
	 * 
	 * 1
	 * 2 1 2 
	 * A B C 
	 *  
	 * J34UTQ4L  
	 */
	
	
	public void towerOfHanoi(Stack<Integer> A, Stack<Integer> B, Stack <Integer> C)
	{
		towerOfHanoiHelper(A.size(), A, B, C);
		//System.out.println(C);
	}

	private void towerOfHanoiHelper(int i, Stack<Integer> start, Stack<Integer> aux, Stack<Integer> end) {
		
		if(i == 0)
		{
			System.out.println("Moving " + start.peek()+" from "+start.toString() +" to "+end.toString());
			end.push(start.pop());
			return;
		}
		
			//if(i+1<=start.size())
			towerOfHanoiHelper(i-1, start, end, aux);
			if(!start.isEmpty())
			{
				System.out.println("Moving " + start.peek()+" from "+start.toString() +" to "+end.toString());
				end.push(start.pop());
				
			}
			//if(aux.size()>=i+1)
			towerOfHanoiHelper(i-1, aux, start, end);
		
		
		
	}
	
	
	
}
