import java.util.Arrays;
import java.util.Stack;

public class code135 {
    public int candy(int[] ratings) {
        //自己的方法，本来是想着从两边遍历，但是遍历的方法错误，采用了stack，降低了运行速度
        int len = ratings.length;
        if(len==1){
            return 1;
        }
        int[] candies = new int[len];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<len-1;i++){
            if(ratings[i]>ratings[i+1]){
                s.push(i);
            }
        }
        while(!s.isEmpty()){
            if(candies[s.peek()]<=candies[s.peek()+1]){
                candies[s.peek()]=candies[s.peek()+1]+1;
            }
            s.pop();
        }
        for(int i=len-1;i>0;i--){

            if(ratings[i]>ratings[i-1]){
                s.push(i);
            }

        }
        while(!s.isEmpty()){
            if(candies[s.peek()]<=candies[s.peek()-1]){
                candies[s.peek()]=candies[s.peek()-1]+1;
            }
            s.pop();
        }
        int res=0;
        for(int i=0;i<len;i++){
            res+=candies[i]+1;
        }
        return res;
    }

    //正确的从两边遍历的方法
    public int candy1(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }
}
