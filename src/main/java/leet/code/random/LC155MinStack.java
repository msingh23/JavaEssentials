/**
 * 
 */
package leet.code.random;

import java.util.Stack;

/**
 * @author manu
 *
 */
public class LC155MinStack {

	
	  /** initialize your data structure here. */
	/*
    Stack<Integer> valStack;
    Stack<Integer> minStack;
    public LC155MinStack() {
        
        valStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        
        valStack.add(x);
        if(minStack.isEmpty())
            minStack.add(x);
        else
            minStack.add(minStack.peek()< x ? minStack.peek():x );
             
    }
    
    public void pop() {
        
        valStack.pop();
        minStack.pop();
        
    }
    
    public int top() {
        if(!valStack.isEmpty())
            return valStack.peek();
        return -1;
    }
    
    public int getMin() {
          if(!minStack.isEmpty())
            return minStack.peek();
          return -1;
    }
    */
	

    /** initialize your data structure here. */
    Stack<Integer> valStack;
    Integer min;
    public LC155MinStack() {
        
        valStack = new Stack<Integer>();
        //minStack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        
        if(x <= min && x!= Integer.MAX_VALUE)
        {
            valStack.push(min);
            min = x;
        }
        valStack.push(x);
    }
    
    public void pop() {
        
        if(valStack.peek().equals(min) )
        {
          //   System.out.println("EQUALS: ");
             valStack.pop();
             min = valStack.pop();
        }
        else valStack.pop();
        // System.out.println("pop: " + valStack+ " minVal: " + min);
    }
    
    public int top() {
        // System.out.println("top: " + valStack+ " minVal: " + min);
        if(!valStack.isEmpty())
            return valStack.peek();
        return -1;
    }
    
    public int getMin() {
         //System.out.println("min: " + valStack+ " minVal: " + min);
          return min;
    }

    
}
