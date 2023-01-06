package week4;
// https://leetcode.com/problems/reverse-linked-list/description/



public class ReverseLinkList {


    /*
    *   prev     current     next
    *    null   ->  1     ->   2   ->    3    ->    4   ->    5
    *
    *              prev     current     next
    *    null   <-  1     ->   2   ->    3    ->    4   ->    5
    *
    *                         prev     current     next
    *    null   <-  1     <-   2   ->    3    ->    4   ->    5
    *
    *   5 -> 4 -> 3 -> 2 -> 1 -> null
     * */
    public static ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode previous = null;

        while(current != null){
            // define nxt
            ListNode nxt = current.next;
            current.next = previous;

            // forward previous and current
            previous = current;
            current = nxt;
        }

        return previous;
    }

    /* With Recursion */
    public static ListNode reverseListRecursion(ListNode current, ListNode previous) {

        if(current != null) return previous;
        ListNode nxt = current.next;
        current.next = previous;
        return reverseListRecursion(nxt, current);
    }

    public static void main(String[] args) {

        int[] input = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(input[0], null);

        ListNode previous = head;
        for (int i = 1; i < input.length; i++) {
            ListNode current = new ListNode(input[i]);
            previous.next = current;
            previous = current;
        }

        /* action to reverse list*/
        ListNode reverseHead = reverseList(head);

        /* Print list to check result*/
        ListNode current = reverseHead;
        while(current != null){
            System.out.print(current.val + ", ");
            current = current.next;
        }

    }
}
