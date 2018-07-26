import java.util.Stack;

public class code445 {

     //Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
      }
     //不能采用这种方法，因为int无法存储太大的数
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = "";
        String s2 = "";
        while(l1!=null){
            s1 = s1 + l1.val;
            l1= l1.next;
        }
        while(l2!=null){
            s2 = s2 + l2.val;
            l2= l2.next;
        }
        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);
        double c = a+b;
        String s3 = c+"";
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        for(char ch:s3.toCharArray()){
            l3.next = new ListNode(ch - '0');
            l3 = l3.next;
        }
        return head.next;
    }
    //这种方法运行效率太低
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        String s1 = "";
        String s2 = "";
        while(l1!=null){
            s1 = s1 + l1.val;
            l1= l1.next;
        }
        while(l2!=null){
            s2 = s2 + l2.val;
            l2= l2.next;
        }
        int[] a = new int[s1.length()];
        int[] b = new int[s2.length()];
        for(int i=0;i<s1.length();i++){
            a[i] = s1.charAt(i)-'0';
        }
        for(int i=0;i<s2.length();i++){
            b[i] = s2.charAt(i)-'0';
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int[] c = new int[Math.max(len1,len2)+1];
        int len3 = c.length;
        int flag =0;
        while(len1>0 && len2>0){
            if(a[len1-1]+b[len2-1]+flag>=10){
                c[len3-1]=a[len1-1]+b[len2-1]+flag-10;
                flag =1;
            }else{
                c[len3-1]=a[len1-1]+b[len2-1]+flag;
                flag =0;
            }
            len1--;
            len2--;
            len3--;
        }
        while(len1>0){
            if(a[len1-1]+flag>=10){
                c[len3-1]=a[len1-1]+flag-10;
                flag =1;
            }else{
                c[len3-1]=a[len1-1]+flag;
                flag =0;
            }
            len3--;
            len1--;
        }
        while(len2>0){
            if(b[len2-1]+flag>=10){
                c[len3-1]=b[len2-1]+flag-10;
                flag =1;
            }else{
                c[len3-1]=b[len2-1]+flag;
                flag =0;
            }
            len3--;
            len2--;
        }
        if(flag==1){
            c[0]=1;
        }
        ListNode l3 = new ListNode(c[0]);
        ListNode head = l3;
        for(int i =1;i<c.length;i++){
            l3.next= new ListNode(c[i]);
            l3= l3.next;
        }
        if (head.val==0){
            return head.next;
        }else{
            return head;
        }
    }
    //这个方法更加简洁高效  使用了stack
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;    //这里直接从列表的最后一个节点开始创建赋值
            ListNode head = new ListNode(sum / 10); //创建下一个节点，这个节点实际上位置在上一个创建的节点之前
            head.next = list; //连接新创建的节点和之前的
            list = head; //将list指向列表第一个节点
            sum /= 10; //sum实际上存储了进位信息
        }

        return list.val == 0 ? list.next : list;
    }
}
