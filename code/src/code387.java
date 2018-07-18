public class code387 {
    public int firstUniqChar(String s) {
        int index=-1;
        flag:
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(i!=j && s.charAt(i)==s.charAt(j)){
                    break;
                }
                if(j==s.length()-1){
                    index = i;
                    break flag;
                }
            }
        }
        return index;
    }
}
//时间复杂度有O(n^2)，discuss中有采用hashset和hashmap的做法，空间复杂度大，但是可以降低时间复杂度
