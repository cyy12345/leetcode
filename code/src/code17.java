import java.util.ArrayList;
import java.util.List;

public class code17 {
    //这道题可以用队列的数据结构来简化这个做法  即直接在LinkedList做
    //通过remove add 的操作
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        String str2 = "abc";
        String str3 = "def";
        String str4 = "ghi";
        String str5 = "jkl";
        String str6 = "mno";
        String str7 = "pqrs";
        String str8 = "tuv";
        String str9 = "wxyz";
        String[] strs = {str2,str3,str4,str5,str6,str7,str8,str9};

        char[] ca = digits.toCharArray();

        String[][] addstrs = new String[ca.length][];
        addstrs[0]= new String[strs[ca[0]-'2'].length()];
        for(int i=0;i<strs[ca[0]-'2'].length();i++){
            char c = strs[ca[0]-'2'].charAt(i);
            addstrs[0][i] = Character.toString(c);
        }
        for(int i=1;i<ca.length;i++){
            int count = 0;
            addstrs[i] = new String[strs[ca[i]-'2'].length()*addstrs[i-1].length];
            for(int k=0;k<addstrs[i-1].length;k++){

                for(int j=0;j<strs[ca[i]-'2'].length();j++){
                    addstrs[i][count] = addstrs[i-1][k]+Character.toString(strs[ca[i]-'2'].charAt(j)) ;
                    count++;
                }
            }
        }
        for(int i=0;i<addstrs[ca.length-1].length;i++){
            res.add(addstrs[ca.length-1][i]);
        }
        return res;
    }
}
