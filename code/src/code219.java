import java.util.HashSet;
import java.util.Set;

public class code219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<=k;j++){
                if(i+j>nums.length-1)
                {
                    break;
                }
                if(nums[i]==nums[i+j]){
                    return true;
                }
            }
        }
        return false;
    }
}
