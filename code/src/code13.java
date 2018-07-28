public class code13 {
    public int romanToInt(String s) {
        String[] strs1 = {"I","V","X","L","C","D","M"};
        String[] strs2 = {"IV","IX","XL","XC","CD","CM"};
        int[] ints1 = {1,5,10,50,100,500,1000};
        int[] ints2 = {-2,-2,-20,-20,-200,-200};
        int res=0;
        for(int i=0;i<s.length()-1;i++){
            for(int j=0;j<strs2.length;j++){
                if(s.substring(i,i+2).equals(strs2[j])){
                    res+=ints2[j];
                }
            }
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<strs1.length;j++){
                if(s.substring(i,i+1).equals(strs1[j])){
                    res+=ints1[j];
                }
            }
        }
        return res;
    }
}
