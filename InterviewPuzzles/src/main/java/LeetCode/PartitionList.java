package LeetCode;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {

		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);

		ListNode curr1 = head1;
		ListNode curr2 = head2;
		while (head != null) {
			if (head.val < x) {
				curr1.next = head;
				curr1 = head;
			} else {
				curr2.next = head;
				curr2 = head;
			}
			head = head.next;
		}
		curr2.next = null;
		curr1.next = head2.next;
		return head1.next;
	}

	public static void main(String[] args) {
		int[] input = { 1, 4, 3, 2, 5, 2 };
		int x = 3;
		ListNode node = new ListNode(input[0]);
		ListNode root = node;
		for (int i = 1; i < input.length; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		root = new PartitionList().partition(root, x);
		while (root != null) {
			System.out.println(root.val);
			root = root.next;
		}

	}
}

// class ListNode {
// int val;
// ListNode next;
//
// ListNode(int x) {
// val = x;
// }
// }
