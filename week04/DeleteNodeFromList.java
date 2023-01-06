package week4;
// https://leetcode.com/problems/delete-node-in-a-linked-list/


public class DeleteNodeFromList {

    /*
     *      4  ->   5   ->   1  ->  9
     *
     *      4  ->   1   ->   1  ->  9
     *
     *      4  ->   1   ->   9
     * */
    public static void deleteNode(ListNode node) {

        ListNode nxt = node.next;

        /*Copy the value of next element and reference*/
        node.val = nxt.val;
        node.next = nxt.next;

        /* remove the next element*/
        nxt = null;
    }


    public static void main(String[] args) {

        int[] input = new int[]{4, 5, 1, 9};
        int deletedNodeVal = 5;

        ListNode head = new ListNode(input[0], null);
        ListNode previous = head;
        ListNode deletedNode = head;

        for (int i = 1; i < input.length; i++) {
            ListNode current = new ListNode(input[i]);
            previous.next = current;
            previous = current;
        }

        /* Get the exact node of deletedNodeVal */
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if( curr.val == deletedNodeVal){
                deletedNode = curr;
                break;
            }
        }

        deleteNode(deletedNode);

        /* Print list to check result*/
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
    }
}
