public class code400 {
    public int findNthDigit(int n) {
        int i=1;
        int num=0;
        while (num<n){
            if(num+(Math.pow(10,i)-Math.pow(10,i-1))*i<n) {
                num += (Math.pow(10, i) - Math.pow(10, i - 1)) * i;
                i++;
            }else{
                break;
            }
        }
        int x=0;
        x = n-num;
        int rem = x%i;
        int shang = x/i;
        int y=0;

        y=(int)Math.pow(10,i-1)+shang;
        return (Integer.parseInt((y+"").substring(rem,rem+1)));
    }
    //想法差不多  但是实现起来简单很多  关键没有找到规律
    public int findNthDigit1(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len; //这里的技巧  将自然顺序与index校准
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
