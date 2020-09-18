/*

LeetCode Problem

Linked List Cycle Part 2

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.

Constraint: You should not modify the Linked List.

Can you try to solve it in O(1) extra space?

*/


/*

Approach: Two pointer technique (Floyd's cycle detection algorithm)

          Initialize two pointers slow and fast to head. Advance fast by two place and slow by one place.
          If these pointers meet at a particular node, we have established that there is a cycle in the Linked List.

          If fast becomes null or it's next is null, then we can conclude that there is no cycle in the list.

          Once we have reached this point, we move one of the pointers back to head. Advance each pointer by 1 place.
          The spot, where these two pointers then meet is the starting point of they cycle in the list.

Time Complexity: O(n)

*/


public ListNode detectCycle(ListNode head) {

        if(head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                fast = head;
                while(slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
}
