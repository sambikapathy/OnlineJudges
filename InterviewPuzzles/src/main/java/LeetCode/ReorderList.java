package LeetCode;

public class ReorderList {

	 private ListNode temp = null;
	    public void reorderList(ListNode head) {
	        temp = head;
	        recur(head);
	    }
	    
	    private boolean done = false;
	    private void recur(ListNode curr){
	        if(curr == null){
	            return ;
	        }
	        recur(curr.next);
	        if(done){
	        	return;
	        }
	        if(temp == curr){
	        	done = true;
	        	return;
	        }
	        if(temp.next == curr){
	        	curr.next = null;
	        	done = true;
	        	return;
	        }
	        curr.next = temp.next;
	        temp.next = curr;
	        temp = temp.next.next;
	    }
	    
	    public static void main(String[] args) {
			int [] input = {1,2,3};
			ListNode head = null;
			ListNode curr = null;
			for(int i : input){
				ListNode temp = new ListNode(i);
				if(head == null){
					head = temp;
					curr = temp;
				}else{
					curr.next = temp;
					curr = temp;
				}
			}
			new ReorderList().reorderList(head);
			System.out.println(head);
		}
}

 class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	
	@Override
	public String toString(){
		return val+"";
	}
}
