package week4;
//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
import java.util.ArrayList;
import java.util.Collections;

class Solution {


    public  ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while(current!= null){
            ListNode nxt = current.next;
            current.next = previous;

            previous = current;
            current = nxt;
        }
        return previous;
    }

    public  int getTotalLength(ListNode head) {
        int totalLength = 0;
        ListNode current = head;
        while(current != null){
            totalLength++;
            current = current.next;
        }
        return totalLength;
    }

    public  ListNode getNodeOfIndex(ListNode head, int index) {
        ListNode current = head;
        while(index-- > 0){
            current = current.next;
        }
        return current;
    }
    public int pairSum(ListNode head) {
        int totalLength = getTotalLength(head);
        int middle = totalLength / 2;

        ListNode middleNodeHead = getNodeOfIndex(head, middle - 1);
        ListNode reverseHead = reverseList(middleNodeHead);

        ListNode current = head;
        ListNode reverseCurrent = reverseHead;
        int result = 0;

        while(middle-- > 0){

            result = Integer.max( (current.val + reverseCurrent.val), result);

            current = current.next;
            reverseCurrent = reverseCurrent.next;
        }

        return result;
    }
}


public class MaximumTwinSum {

    public static void main(String[] args) {

        int[] input = new int[]{5,4,2,1};
        int numberOfNodeDeleteFromEnd = 2;

        ListNode head = new ListNode(input[0], null);
        ListNode previous = head;

        for (int i = 1; i < input.length; i++) {
            ListNode current = new ListNode(input[i]);
            previous.next = current;
            previous = current;
        }

        Solution solution = new Solution();


        System.out.println(solution.pairSum(head));

    }
}
