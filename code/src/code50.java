public class code50 {
    /*
    Implement pow(x, n), which calculates x raised to the power n (xn).
     */
    double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0){
            return 1/x*myPow(1/x,-(n+1));
        }
        return n%2==0 ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
    public double myPow1(double x, int n) {
        if(n==0){
            return 1;
        }
        double ans = 1;
        boolean flag = false;
        if(n<0){
            if(n==Integer.MIN_VALUE){
                n=-(n+1);
                flag = true;
            }else{
                n=-n;
            }
            x=1/x;
        }

        while(n>0){
            if(flag==true){
                x*=x;
                flag = false;
            }
            if( (n&1)==1) ans *=x;
            x*=x;
            n>>=1;
        }
        return ans;
    }
}
