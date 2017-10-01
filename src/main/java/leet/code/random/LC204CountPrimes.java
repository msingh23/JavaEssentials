package leet.code.random;

public class LC204CountPrimes {

    /*
    public int countPrimes(int n) {
     
        if(n<=2) return 0;
        List<Integer> primes = new ArrayList<Integer>(Arrays.asList(2));
        
        for(int i = 3 ;i <n ;i ++)
        {
            boolean prime = true;
            for(int j = 0 ;primes.get(j) * primes.get(j) <= i; j++)
            {
                if(i%primes.get(j) == 0)
                {
                    prime = false;
                    break;
                }
               
            }
             if(prime) primes.add(i);
        }
        return primes.size();
    }
    */
     public int countPrimes(int n) 
     {
         boolean [] notPrime = new boolean[n];
         int count = 0;
         for(int i = 2; i*i<=n ;i ++)
         {
             if(notPrime[i])
                 continue;
             for(int j = i ; j * i < n ; j++)
                notPrime[j*i] = true;
         }
         
         for(int i = 2; i < n ; i++)
             if(!notPrime[i]) count++;
         
         return count;
     }
	
}
