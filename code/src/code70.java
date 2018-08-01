public class code70 {
    /*
    You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
     */
    public int climbStairs(int n) {
        int[] mem = new int[n+1];

        return recurse(0,n,mem);
    }

    public int recurse(int i,int n,int[] mem){
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }
        if(mem[i]>0){
            return mem[i];
        }
        mem[i] = recurse(i+1,n,mem)+recurse(i+2,n,mem);
        return mem[i];
    }

    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
