/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author manu
 *
 */
public class LFUCache460 {
    
	  /*
	  0(n) 
	  
	  
	HashMap<Integer,Integer> mp = new HashMap<Integer, Integer>();
	    PriorityQueue<int[]> pq = new PriorityQueue<int []>((a,b)-> a[1]==b[1]?a[2]-b[2]:a[1]-b[1] );
	    PriorityQueue<int[]> pq2= new PriorityQueue<int []>((a,b)-> a[1]==b[1]?a[2]-b[2]:a[1]-b[1] );
	    int size =0;
	    int capacity = 0;
	    int time =0;

	    public LFUCache460(int capacity) {
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        int val = mp.getOrDefault(key, -1);
	        if(val !=-1)
	        {
	        	 while(!pq.isEmpty())
	             {
	                 int [] data = pq.poll();
	                 if(data[0]==key)
	                 {
	                     data[1] = data[1]+1;
	                     data[2] = time++;
	                 }
	                 pq2.add(data);
	             }
	             pq = pq2;
	             pq2= new  PriorityQueue<int []>((a,b)-> a[1]==b[1]?a[2]-b[2]:a[1]-b[1] );
	        }
	        return val;
	    }
	    
	    public void put(int key, int value) {
	        int val = mp.getOrDefault(key, -1);
	        if(val ==-1)
	        {
	            if(size>=capacity )
	            {
	                if(pq.isEmpty()) return;
	                int [] remove = pq.poll();
	                mp.remove(remove[0]);
	                size--;
	            }
	            
	            mp.put(key,value);
	            pq.add(new int[]{key, 0, time++});
	            size++;
	        }else
	        {
	            mp.put(key,value);
	            while(!pq.isEmpty())
	            {
	                int [] data = pq.poll();
	                if(data[0]==key)
	                {
	                    data[1] =data[1]+1;
	                    data[2] = time++;
	                }
	                pq2.add(data);
	            }
	            pq = pq2;
	            pq2= new  PriorityQueue<int []>((a,b)-> a[1]==b[1] ? a[2] - b[2] : a[1] - b[1] );
	        }
	    }
	
  */
	
	/*
	 0(logn)
	
    HashMap<Integer,CacheItem> mp = new HashMap<Integer, CacheItem>();
    PriorityQueue<CacheItem> pq = new PriorityQueue<CacheItem>((a,b)-> a.count == b.count ? a.time - b.time : a.count - b.count);
    int time =0;
    int capacity = 0;
    
    public LFUCache460(int capacity) 
    {
        this.capacity = capacity;
    }
    
      public int get(int key) 
      {
          CacheItem item = mp.getOrDefault(key, null);
          if(item ==null)
          {
              return -1;
          }else
          {
              pq.remove(item);
              item.count =  item.count+1;
              item.time = time++;
              pq.add(item);
          }
          return item.val;
      }
    
     public void put(int key, int value) 
     {
         
         CacheItem exist = mp.getOrDefault(key , null);
         
          if(exist ==null){
              
              if(capacity==0)
                {
             
                    if(pq.isEmpty())
                      {
                         return;
                      }
                  else
                     {
                        CacheItem low = pq.poll();
                        mp.remove(low.key);
                        capacity++;
                      }
                }
              
                 CacheItem add = new CacheItem(value, 0, time++, key);
                 mp.put(key,add);
                 pq.add(add);
                 capacity--;
            }             
            else
             {
                 pq.remove(exist);
                exist.count =  exist.count+1;
                exist.time = time++;
                exist.val = value;
                pq.add(exist);
                
             }
         
     }
    
    
    public class CacheItem{
        
        int val; 
        int count;
        int time;
        int key;
        
        public CacheItem( int val, int count, int time, int key)
        {
            this.val = val;
            this.count = count;
            this.time = time;
            this.key = key;
        }
        
    }
    
    */
	
	/*
	 * logn
	 
	HashMap<Integer, CacheItem> mp = new HashMap<Integer, CacheItem>();
    TreeMap<CacheItem, Integer> sortmp = new TreeMap<CacheItem, Integer>((a,b)-> a.count == b.count ? a.time - b.time : a.count - b.count);
    int time =0;
    int capacity = 0;
    
    public LFUCache460(int capacity) 
    {
        this.capacity = capacity;
    }
    
     public int get(int key) 
     {
         
         CacheItem item = mp.getOrDefault(key, null);
         if(null == item) return -1;
         mp.remove(key);
         sortmp.remove(item);
         item.count+=1;
         item.time = time++;
         mp.put(key, item);
         sortmp.put(item, key);
         
         return item.val;
         
     }
    
     public void put(int key, int value) 
     {
         CacheItem item = mp.getOrDefault(key, null);
         if(null == item)
         {
            if(0 == capacity)
            {
                if(sortmp.size()==0) return;
               CacheItem less =  sortmp.pollFirstEntry().getKey();
                mp.remove(less.key);
                capacity++;
            }
             
            CacheItem newItem = new CacheItem(value, 0, time++, key);
            mp.put(key, newItem);
            sortmp.put(newItem, key);
            capacity--;
             
         }else
         {
             sortmp.remove(item);
             item.count+=1;
             item.time = time++;
             item.val = value;
             mp.remove(key);
             mp.put(key, item);
             sortmp.put(item, key);
             
         }
        
         
     }
    
    */
    public class CacheItem{
        
        int val; 
        int count;
        int time;
        int key;
        
        public CacheItem( int val, int count, int time, int key)
        {
            this.val = val;
            this.count = count;
            this.time = time;
            this.key = key;
        }
        
    }
    int capacity;
    Node head = new Node();
    HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
    HashMap<Integer, Node> countMap = new HashMap<Integer, Node>();
    
    
    public LFUCache460(int capacity) 
    {
        this.capacity = capacity;
    }    
    public int get(int key)
    {
        int val = mp.getOrDefault(key, -1);
        if(-1 ==val) return val;
        updateCount(key);
        return val;
    }
    
    public void createCountNode(Node current, Node next, int key)
    {
        if(next == null){
            next = new Node();    
            next.count = current.count+1;  
            next.next = current.next ;
            next.prev= current;
            current.next =next;
            if(next.next!=null)
            next.next.prev= next;
        }
         current.set.remove(key);
        if(current.set.size()==0)
        {
            remove(current);
        }
         next.set.add(key);
        
    }
    public void remove(Node curr)
    {
        if(curr.next!=null){
            curr.next.prev = curr.prev;
        }
        if(curr.prev !=null){
            curr.prev.next = curr.next;
        }
    }
    
    public void updateCount(int key)
    {
        
            Node countNode = countMap.get(key);
            if(countNode.next ==null || countNode.next.count>countNode.count+1)
            {
                createCountNode(countNode, null, key);
            }
            else
            {
                createCountNode(countNode, countNode.next, key);
            }
            
        countMap.put(key,countNode.next);
           
       
    }
    
     public void put(int key, int value) 
     {
         int val = mp.getOrDefault(key, -1);
         if(val ==-1)
         {
             if(capacity>0)
             {
                 mp.put(key, value);
                 //addToHead(key);
                 capacity--;
             }
             else if(capacity==0)
             {
                 if(head.next==null) return ;
                 removeOld();
                 mp.put(key, value);
             }
             addToHead(key);
         }else
         {
             mp.put(key, value);
             updateCount(key);
         }
         
         
     }
    
    public void addToHead(int key)
    {
        if(null == head.next)
        {
            Node node = new Node();
            node.set.add(key);
            head.next = node;
            node.prev = head; 
        }else{
        	
        	if(head.next.count>0){
        		 Node node = new Node();
                 node.set.add(key);
                 node.next = head.next;
                 node.prev= head;
                 head.next= node;
                 node.next.prev=node;
                 
        	}else{
        		head.next.set.add(key);
        	}
        }
        countMap.put(key, head.next);
    }
         
    public void removeOld()
    {
        if(null == head.next) return ;
        int old = 0;
        for(int key: head.next.set)
        {
            old = key;
            break;
        }
        mp.remove(old);
        head.next.set.remove(old);
        if(head.next.set.size()==0){
            remove(head.next);
        }
        countMap.remove(old);
        
    }
    public class Node
    {
    
    Node prev = null;
    Node next = null;
    int count = 0;
    LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
    
    }

	
    public static void main(String[] args) {
		LFUCache460 ca = new LFUCache460(3);
		ca.put(2, 2);
		ca.put(1, 1);
		System.out.println(ca.get(2));
		System.out.println(ca.get(1));
		System.out.println(ca.get(2));
		ca.put(3, 3);
		ca.put(4, 4);
		System.out.println(ca.get(3));
		System.out.println(ca.get(2));
		System.out.println(ca.get(1));
		System.out.println(ca.get(4));
		
	}
}