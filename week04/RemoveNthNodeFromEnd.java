package week4;
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        return head;
    }

    public static void main(String[] args) {

        int[] input = new int[]{1,2,3,4,5};
        int numberOfNodeDeleteFromEnd = 2;

        ListNode head = new ListNode(input[0], null);
        ListNode previous = head;
        ListNode deletedNode = head;

        // Construct the link list
        for (int i = 1; i < input.length; i++) {
            ListNode current = new ListNode(input[i]);
            previous.next = current;
            previous = current;
        }

        removeNthFromEnd(head, numberOfNodeDeleteFromEnd );

        /* Print list to check result*/
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
    }
}
