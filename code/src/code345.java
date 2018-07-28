public class code345 {
    public String reverseVowels(String s) {
        if(s.length()==0){
            return "";
        }
        int start =0;
        int  end =s.length()-1;
        String vowels = "aeiouAEIOU";
        char[] ca = s.toCharArray();
        while(start<end){
            while(start<end && !vowels.contains(ca[start]+"")){
                start++;
            }
            while(start<end && !vowels.contains(ca[end]+"")){
                end--;
            }
            char temp=' ';
            temp=ca[start];
            ca[start]=ca[end];
            ca[end]=temp;
            start++;
            end--;
        }

        return new String(ca);

    }
}
