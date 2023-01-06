package week4;

//https://leetcode.com/problems/linked-list-cycle/

public class LinkListCycle {

    public static boolean hasCycle(ListNode head) {

        /*
        // brute force attempt ----------------------------------
        HashMap<ListNode, Boolean> seenMap = new HashMap<>();
        ListNode current = head;
        while(current != null){
            if(seenMap.containsKey(current)) return true;
            seenMap.put(current, true);
            current = current.next;
        }
        return false;*/


        // Floyd's Tortoise and Hare Algorithm  ----------------------------------
        // https://dev.to/alisabaj/floyd-s-tortoise-and-hare-algorithm-finding-a-cycle-in-a-linked-list-39af

        if (head == null || head.next == null) return false;

        ListNode tortoise = head;
        ListNode hare = head.next;

        while (hare != null && hare.next != null) {
            if (tortoise == hare) {
                return true;
            }
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 0, -4};

        ListNode head = new ListNode(input[0], null);
        ListNode previous = head;

        for (int i = 1; i < input.length; i++) {
            ListNode current = new ListNode(input[i]);
            previous.next = current;
            previous = current;
        }

        /* Make a cycle in list */
        previous.next = head;


        System.out.println("Has Cycle in link list : " + hasCycle(head));
    }
}
