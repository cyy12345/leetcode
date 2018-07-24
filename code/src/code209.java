public class code209 {
    /*
    Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
     */
    // O（n^2）
    public int minSubArrayLen1(int s, int[] nums) {
        int min = nums.length+1;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum = sum + nums[j];
                if(sum>=s && j-i+1 < min) {
                    min = j-i+1;
                    break;
                }
            }
        }
        if(min == nums.length+1) return 0;
        return min;
    }
    //0(n)
    public int minSubArrayLen(int s, int[] nums)
    {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

}
