public class code461 {
    /*
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

     */
    public int hammingDistance(int x, int y) {
        int rem1=0;
        int rem2=0;
        int hamming = 0;

        while(x>0 || y>0){
            if(x>0) {
                rem1 = x%2;
                x=x/2;
            }else{
                rem1=0;
            }
            if(y>0) {
                rem2 = y%2;
                y=y/2;
            }else{
                rem2=0;
            }
            if(rem1!=rem2){
                hamming++;
            }
        }
        return hamming;
    }
}
