public class code654 {
    /*
    Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.
     */
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length);

    }

    public TreeNode helper(int[] nums,int start,int end){

        int max=0;
        int maxindex=start;
        if(end==start){
            return null;
        }

        for(int i=start;i<end;i++){
            if(nums[i]>=max){
                max= nums[i];
                maxindex=i;
            }
        }
        TreeNode root = new TreeNode(max);

        root.left=helper(nums,start,maxindex);
        root.right=helper(nums,maxindex+1,end);
        return root;

    }
}
