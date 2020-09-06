/*

LeetCode Problem 876

Middle of the Linked List

Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.

*/




/*

Approach: This problem can be solved in 2-passes by calculating the length of the list in the first pass and then dividing
          it by 2 and travelling to the middle element.

          For a single-pass solution, we use 2-pointer technique. We initialize two pointers - fast and slow.
          Move fast ahead by 2 places in each iteration and slow by 1 place.

          When fast reaches towards end of the linked list, slow points to the middle of the list.

          In the case where the list has even number of elements, we have 2 middles, so we return the second one.


Time Complexity: O(n)

*/


public ListNode middleNode(ListNode head) {

        ListNode fast=head, slow=head;

        while(fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast.next!=null) {
            slow = slow.next;
        }

        return slow;
}
