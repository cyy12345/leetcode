public class code171 {
    /*
    Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
     */
    public int titleToNumber(String s) {
        int len = s.length();
        int res=0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            res = res*26+c-'A'+1;
        }
        return res;
    }
}
