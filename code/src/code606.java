public class code606 {
    /*
    You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs
that don't affect the one-to-one mapping relationship between the string and the original binary tree.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public String tree2str(TreeNode t) {
        return helper(t);
    }
    public String helper(TreeNode r){
        String output="";
        if(r==null){
            return output;
        }
        output= output+r.val;
        if(r.left==null && r.right==null){
            return output;
        }
        else if(r.left!=null && r.right==null){
            output= output + "("+  helper(r.left)  + ")";
        }else if(r.left==null && r.right!=null){
            output+="("+")"+"("+helper(r.right)+")";
        }else if(r.left!=null && r.right!=null){
            output+="("+helper(r.left)+")";
            output+="("+helper(r.right)+")";
        }
        return output;
    }
}
