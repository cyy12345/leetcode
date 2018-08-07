import java.util.ArrayList;
import java.util.List;

public class code241 {
    /*
    Given a string of numbers and operators, return all possible results from computing all the different possible ways
     to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> output = new ArrayList<>();
        int len = input.length();
        for(int i=0;i<len;i++){
            char c = input.charAt(i);
            if(c=='*' || c=='+' ||c=='-'){
                List<Integer> l1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> l2 = diffWaysToCompute(input.substring(i+1));
                for(int a:l1){
                    for(int b:l2){
                        if(c=='*'){
                            output.add(a*b);
                        }else if(c=='+'){
                            output.add(a+b);
                        }else if(c=='-'){
                            output.add(a-b);
                        }
                    }
                }
            }
        }
        if(output.isEmpty()) output.add(Integer.parseInt(input));
        return output;
    }
}
