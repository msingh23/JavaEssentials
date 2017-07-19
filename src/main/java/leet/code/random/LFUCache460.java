/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
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
    

	
    public static void main(String[] args) {
		LFUCache460 ca = new LFUCache460(2);
		ca.put(1, 1);
		ca.put(2, 2);
		System.out.println(ca.get(1));
		ca.put(3, 3);
		System.out.println(ca.get(2));
		System.out.println(ca.get(3));
		ca.put(4, 4);
		System.out.println(ca.get(1));
		System.out.println(ca.get(3));
		System.out.println(ca.get(4));
		
	}
}