import java.util.Stack;

public class code67 {
    /*
    Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.
     */
    public String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public String addBinary(String a, String b) {
        String c = "";
        int flag = 0;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer>  s2 = new Stack<>();
        for(int i=0;i<a.length();i++){
            s1.push(a.charAt(i)-'0');
        }
        for(int i=0;i<b.length();i++){
            s2.push(b.charAt(i)-'0');
        }
        while( (!s1.isEmpty()) || (!s2.isEmpty()) ){
            if(s1.isEmpty()){
                if(s2.peek()+flag>=2){
                    c= (s2.pop()+flag-2)+c;
                    flag=1;
                    continue;
                }else{
                    c= (s2.pop()+flag)+c;
                    flag=0;
                    continue;
                }
            }
            if(s2.isEmpty()){
                if(s1.peek()+flag>=2){
                    c= (s1.pop()+flag-2)+c;
                    flag=1;
                    continue;
                }else{
                    c= (s1.pop()+flag)+c;
                    flag=0;
                    continue;
                }
            }
            if(s1.peek()+s2.peek()+flag>=2){
                c=s1.pop()+s2.pop()+flag-2+c;
                flag=1;
            }else{
                c= s1.pop()+s2.pop()+flag+c;
                flag=0;
            }
        }
        if(flag==1){
            return 1+c;
        }else{
            return c;
        }
    }
}
