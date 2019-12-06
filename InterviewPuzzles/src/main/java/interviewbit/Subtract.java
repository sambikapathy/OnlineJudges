package interviewbit;

import LeetCode.ListNode;

public class Subtract {

    public ListNode subtract(ListNode a) {
        if(a.next == null){
            return a;
        }
        int size = 0;
        ListNode b = a;
        while(b != null) {
            size++;
            b = b.next;
        }

        ListNode start = a;
        for(int i=0;i<size/2;i++){
            ListNode temp = a;
            for(int j=0;j<size-i-1;j++){
                //System.out.println(start.val+" -> "+temp.val);
                temp = temp.next;

            }
            start.val = temp.val - start.val;
            start = start.next;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] input = { 1, 2, 3 };
        ListNode head = null;
        ListNode curr = null;
        for (int i : input) {
            ListNode temp = new ListNode(i);
            if (head == null) {
                head = temp;
                curr = temp;
            } else {
                curr.next = temp;
                curr = temp;
            }
        }
    }
}
