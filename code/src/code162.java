public class code162 {
    /*
    A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.
     */
    public int findPeakElement(int[] nums) {
        if(nums.length==1 ||nums[0]>nums[1]){
            return 0;
        }

        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        int index = 0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i+1] && nums[i]>nums[i-1]){
                index =i;
                break;
            }
        }
        return index;

    }
}
