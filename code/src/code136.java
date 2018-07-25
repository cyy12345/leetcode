import javax.swing.table.TableCellEditor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

        Note:

        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Example 1:

        Input: [2,2,1]
        Output: 1
        Example 2:

        Input: [4,1,2,1,2]
        Output: 4
        */
public class code136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int output = 0;
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1){
                output = nums[i];
                break;
            }
            if(nums[i]!=nums[++i]){
                output = nums[i-1];
                break;
            }
        }
        return output;
    }
    //使用异或的方法  没有用多余空间  时间复杂度O(n)
    public int singleNumber1(int[] nums){
        int a=0;
        for(int num : nums){
            a ^= num;
        }
        return a;
    }
    //使用hashtable
    public int singleNumber2(int[] nums){

        HashMap<Integer,Integer> ht= new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(ht.containsKey(nums[i])){
                ht.remove(nums[i]);
            }
            ht.put(nums[i],i);
        }
        return  ht.keySet().iterator().next();

    }
}
