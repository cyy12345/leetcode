public class code283 {
    /*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     */
    public void moveZeroes(int[] nums) {
        int lastzero = nums.length;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0 && i<lastzero){
                for(int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
                nums[nums.length-1] = 0;
                lastzero--;
                i--;
            }

        }
    }
//O(N)
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
