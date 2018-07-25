import java.util.HashMap;
import java.util.Iterator;

public class code260 {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int num : nums){
            if(hm.containsKey(num)){
                hm.remove(num);
            }else{
                hm.put(num,1);
            }
        }
        int[] output = new int[2];
        Iterator<Integer> it = hm.keySet().iterator();
        output[0]=it.next();
        output[1]=it.next();
        return output;
    }
    public int[] singleNumber2(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;  //-diff会按照补码表示，与diff进行与操作之后会得到最右边第一个被set的位置
        //补码的性质就是只有最后一位为1的位与原码相同，其他都相反（不考虑符号位）

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
