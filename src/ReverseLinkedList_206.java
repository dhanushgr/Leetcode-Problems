// https://leetcode.com/problems/reverse-linked-list/


public class ReverseLinkedList_206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;                   

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


// https://leetcode.com/problems/reverse-linked-list/

// https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg
// Input: head = [1,2]
// Output: [2,1]