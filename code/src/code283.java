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
}
