import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class code18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])){   //防止重复
                for(int j=i+1;j<nums.length-2;j++){
                    if(j==i+1 || nums[j] != nums[j-1]){

                        int lo = j+1, hi = nums.length-1, sum = target - nums[i]-nums[j];
                        while (lo < hi) {
                            if (nums[lo] + nums[hi] == sum) {
                                res.add(Arrays.asList(nums[i],nums[j], nums[lo], nums[hi]));
                                while (lo < hi && nums[lo] == nums[lo+1]) lo++;   //防止重复
                                while (lo < hi && nums[hi] == nums[hi-1]) hi--;    //防止重复
                                lo++; hi--;
                            } else if (nums[lo] + nums[hi] < sum) lo++;
                            else hi--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
