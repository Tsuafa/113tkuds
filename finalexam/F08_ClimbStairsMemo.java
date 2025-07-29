package finalexam;

import java.util.*;

public class F08_ClimbStairsMemo {
    
   
    static int[] memo;

   
    public static int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return n;
        
        if (memo[n] != -1) return memo[n];

     
        memo[n] = climbStairs(n - 1) + climbStairs(n - 2) + climbStairs(n - 3);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

       
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        
        System.out.println("Ways: " + climbStairs(n));
    }
}
