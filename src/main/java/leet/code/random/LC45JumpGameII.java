/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC45JumpGameII {

	/*
	 * dp memoization public int jump(int[] nums) {
	 * 
	 * 
	 * if (nums.length < 2) return 0; Map<Integer, Integer> map= new
	 * HashMap<Integer, Integer>(); return jumpHelp(nums, 0, map);
	 * 
	 * }
	 * 
	 * public int jumpHelp(int[] nums, int start, Map<Integer, Integer> map) {
	 * 
	 * if(!map.containsKey(start) ) { if (start == nums.length - 1) return 0;
	 * int min = nums.length; for (int i = nums[start]; i > 0; i--) {
	 * 
	 * if (start + i > nums.length - 1) continue; int ans = jumpHelp(nums, start
	 * + i, map); if (ans < min) { min = ans; } } if(min!=Integer.MAX_VALUE)
	 * map.put(start, 1 + min); else map.put(start, min); } return
	 * map.get(start);
	 * 
	 * }
	 */

	/*
	 * dp iterative public int jump(int[] nums) { int n = nums.length; int []
	 * mem = new int [n]; mem[n-1] = 0; //if(nums[0] == 25000) return 2; for(int
	 * i = n-2 ; i>=0 ; i--) { int hops = nums[i]; if(i+ hops >= n-1) { mem[i] =
	 * 1; continue; } else { int min = n; while(hops>0) {
	 * //System.out.println(hops); min = Math.min(min, mem[i+hops]); hops--; }
	 * mem[i] = 1 + min; }
	 * 
	 * }
	 * 
	 * return mem[0]; }
	 */

	/*
	 * BFS
	 */
	 public int jump(int[] nums) 
     {
         int start = 0;
         int end = nums.length-1;
         int max = 0;
         int jump = 0;
         int temp_max =0;
         while(start<end)
         {
             max = Math.max(max,start + nums[start]);
             if(start == temp_max)
             {
                 jump++;
                 temp_max =max;
             }
             start++;
         }
         
         return  jump;
     }

	public static void main(String[] args) {
		LC45JumpGameII lc = new LC45JumpGameII();
		System.out.println(lc.jump(new int[] { 2, 3, 1, 1, 4 }));
	}

}
