package solutions;

public class Day01_ConvertBinaryNumberInLLToInteger {

	public static int getDecimalValue(ListNode head) {
		int ans = head.val;

		while (head.next != null) {
			ans = ans * 2 + head.next.val;
			head = head.next;
		}

		return ans;
	}

	public static int getDecimalValue_bitmanipulation(ListNode head) {
		int num = head.val;
		while (head.next != null) {
			num = (num << 1) | head.next.val;
			head = head.next;
		}
		return num;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(0);
		node.next.next = new ListNode(1);
		System.out.println(getDecimalValue(node));
		System.out.println(getDecimalValue_bitmanipulation(node));
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}