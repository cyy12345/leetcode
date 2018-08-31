import java.util.Stack;

public class code20 {
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
     */
    public boolean isValid(String s) {
        Stack<Character> q = new Stack<>();
        char[] ca = s.toCharArray();
        for(int i=0;i<ca.length;i++){
            if(ca[i]=='('||ca[i]=='{'||ca[i]=='['){
                q.push(ca[i]);
            }else{
                if(q.isEmpty()){
                    return false;
                }
                if(q.peek()=='(' && ca[i]!=')'){
                    return false;
                }else if(q.peek()=='{' && ca[i]!='}'){
                    return false;
                }else if(q.peek()=='[' && ca[i]!=']'){
                    return false;
                }
                q.pop();
            }
            if(i==ca.length-1 && !q.isEmpty()){
                return false;

            }
        }
        return true;
    }

    public boolean isValid1(String s) {
        Stack<Character> q = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='('){
                q.push(')');
            }else if(c=='{'){
                q.push('}');
            }else if(c=='['){
                q.push(']');
            }else if(q.isEmpty()||q.pop()!=c){
                return false;
            }
        }
        return q.isEmpty();
    }
}
