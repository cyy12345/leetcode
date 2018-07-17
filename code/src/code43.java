public class code43 {
    public String multiply(String num1, String num2) {
        int m = num1.length(),n=num2.length();
        int[] pos = new int[m+n];  //只能用int数组来存储

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i+j,p2 = i+j+1;   //观察乘法
                int sum = mul + pos[p2];

                pos[p1] += sum /10;
                pos[p2]= sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder(); //StringBuilder可以很好的对String进行操作
        for(int p:pos) {
            if(!(sb.length()==0 && p==0)) { //排除了第一位数算出来是0的情况
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString(); //处理了结果为0的情况
    }
    //我自己的方式 无法适应很长的int值  只能够从乘法的运算角度来考虑 不能直接让两个大的int相乘
    public String multiply1(String num1, String num2) {
        char[] numchar1 = num1.toCharArray();
        char[] numchar2 = num2.toCharArray();
        int intnum1 = 0, intnum2 = 0;
        for (int i = 0; i < numchar1.length; i++) {
            intnum1 = intnum1 + (int) Math.pow(10, i) * (numchar1[numchar1.length - 1 - i] - 48);
        }
        for (int i = 0; i < numchar2.length; i++) {
            intnum2 = intnum2 + (int) Math.pow(10, i) * (numchar2[numchar2.length - 1 - i] - 48);
        }

        int mult = intnum2 * intnum1;
        String multinum = new String();
        if (mult == 0) {
            return "0";
        }
        while (mult > 0) {
            multinum = mult % 10 + multinum;
            mult = mult / 10;
        }
        return multinum;
    }
}

