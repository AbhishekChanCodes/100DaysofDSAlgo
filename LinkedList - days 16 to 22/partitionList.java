/*

LeetCode Problem 86

Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

*/



/*

Approach: The first thing that comes to mind is quick sort style partition. However, it would just complicate this problem more.
          We just need to change pointers in the given list.

          Use two pointers to keep track of nodes smaller and greater than given node.
          We parse through the given list. If a node is greater than or equal to given node, the "greater" list points to that node,
          else the "smaller" list adds that node.

          Because we parse through the list sequentially, relative ordering of the elements is not lost.
          We also use two dummy nodes and just change the pointers in the list, so we are modifying the same list without
          using any additional space.

Time Complexity: O(N) where N is the number of nodes in the given linked list.

Space Complexity: O(1)

*/

public ListNode partition(ListNode head, int x) {


        ListNode smallerHead = new ListNode(0), greaterHead = new ListNode(0);

        ListNode smaller = smallerHead;
        ListNode greater = greaterHead;

        while(head != null) {

            if(head.val >= x) {

                greater.next = head;
                greater = greater.next;

            } else {

                smaller.next = head;
                smaller = smaller.next;

            }

            head = head.next;
        }

        greater.next = null;
        smaller.next = greaterHead.next;

        return smallerHead.next;
}
