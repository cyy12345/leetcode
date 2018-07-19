import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code102 {
    /*
    熟悉队列queue操作
    offer()
    peek()
    poll()
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); //LinkedList实现了dequeue接口，是queue的子接口
        List<List<Integer>> trav = new ArrayList<List<Integer>>();

        if (root==null) return trav;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> sublist = new LinkedList<Integer>();
            for(int i=0;i<levelNum;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            trav.add(sublist);
        }
        return trav;
    }
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
}
