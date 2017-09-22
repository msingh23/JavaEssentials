/**
 * 
 */
package leet.code.random;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author manu
 *
 */
public class LC675CutOffTreesforGolfEvent {
	
	  /*
    [1 2]
    [1 2 3 4 5 6 7 8 9]
    */
    
    int steps = 0;
    public int cutOffTree(List<List<Integer>> forest) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->a-b);
        for(List<Integer> row : forest)
            for(Integer patch : row)
                if(patch > 1) pq.add(patch);
        
        
            
        Integer [] cor = new Integer [2];
        cor[0] = 0;
        cor[1] = 0;
        
        while(!pq.isEmpty())
        {
            int tree = pq.poll();
            Integer [] newCor = BFS(forest, cor, tree);
            if(newCor!=null)
            {
                cor = newCor;
            }
            else return -1;
        }

        
        return steps;
    }
    
    public Integer[] BFS(List<List<Integer>> forest, Integer [] start, int tree)
    {
        
        Queue<Integer []> q = new LinkedList<Integer []> ();
        Queue<Integer> count = new LinkedList<Integer>();
        boolean [][]visited = new boolean [forest.size()][forest.get(0).size()];
        q.add(start);
        count.add(0);
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty())
        {
            Integer [] cor = q.poll();
            int x = cor[0];
            int y = cor[1];
            int step = count.poll();
            
            if(forest.get(x).get(y) == tree)
            {
                steps+=step;
                return cor;
            }
            
            if(x-1 >= 0  && !visited[x-1][y] && forest.get(x-1).get(y)!=0)
            {
                q.add(new Integer []{x-1, y});
                count.add(step+1);
                visited[x-1][y] = true;
            }
            if(x+1 < forest.size()  && !visited[x+1][y] && forest.get(x+1).get(y)!=0)
            {
                q.add(new Integer []{x+1, y});
                count.add(step+1);
                visited[x+1][y] = true;
            }
            if(y-1 >= 0 && !visited[x][y-1] && forest.get(x).get(y-1)!=0)
            {
                q.add(new Integer []{x, y-1});
                count.add(step+1);
                 visited[x][y-1] = true;
            }
            
            if(y+1 < forest.get(x).size() && !visited[x][y+1] && forest.get(x).get(y+1)!=0)
            {
                q.add(new Integer []{x, y+1});
                count.add(step+1);
                 visited[x][y+1] = true;
            }
        }
        
        return null;
    }
    

}
