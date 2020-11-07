package solutions;

import java.util.Stack;

public class Day07_AddTwoNumbersII {

	public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
		Stack<Integer> stack1 = convertNumToStack(l1);
		Stack<Integer> stack2 = convertNumToStack(l2);
		/* Now we have created stack for each number
		 * The numbers are automatically stored with their LSB on top and MSB on bottom
		 * i.e they are reversed*/
		
		int sum = 0;
		LinkedListNode node = new LinkedListNode(0);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {

			// Check if the stack is not empty
			if (!stack1.isEmpty()) {
				sum += stack1.pop();
			}

			if (!stack2.isEmpty()) {
				sum += stack2.pop();
			}

			// Now the sum is stored in "sum", overwriting the "0" we stored there earlier
			node.val = sum % 10;

			LinkedListNode carry = new LinkedListNode(sum / 10);
			carry.next = node;
			// copy carry to node
			node = carry;
			sum /= 10;
		}
		System.out.println("here");
		return node.val == 0 ? node.next : node;

	}

	public static void main(String[] args) {
		LinkedListNode l1 = new LinkedListNode(7);
		l1.next = new LinkedListNode(2);
		l1.next.next = new LinkedListNode(4);
		l1.next.next.next = new LinkedListNode(3);

		LinkedListNode l2 = new LinkedListNode(5);
		l2.next = new LinkedListNode(6);
		l2.next.next = new LinkedListNode(4);

		printLinkedList(l1);
		printLinkedList(l2);
		System.out.println(addTwoNumbers(l1, l2));
	}

	public static Stack<Integer> convertNumToStack(LinkedListNode node) {
		Stack<Integer> stack = new Stack<>();
		while (node != null) {
			stack.push(node.val);
			node = node.next;
		}

		return stack;
	}

	private static void printLinkedList(LinkedListNode node) {
		System.out.println("Printing linked list");
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.print("NULL\n\n");
	}

}

class LinkedListNode {
	int val;
	LinkedListNode next;

	LinkedListNode() {
	}

	LinkedListNode(int val) {
		this.val = val;
	}

	LinkedListNode(int val, LinkedListNode next) {
		this.val = val;
		this.next = next;
	}
}