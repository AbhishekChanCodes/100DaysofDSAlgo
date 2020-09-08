/*

LeetCode Problem 141

Linked List hasCycle

Given a linked list, determine if it has a cycle in it.

Follow up:

Can you solve it using O(1) (i.e. constant) memory?

*/



/*

My initial approach: Use a HashSet to see if a node has been visited previously. If it has been, then we have a cycle.
Else, we run out of nodes and return false. HashSet is a good choice here because of it's O(1) insertion and retrieval.


Time Complexity: O(n)

Space Complexity: O(n)

*/
public boolean hasCycle(ListNode head) {

        Set<ListNode> visited = new HashSet<ListNode>();

        while(head != null) {

            if(visited.contains(head))
                return true;

            visited.add(head);
            head = head.next;

        }
        return false;
}




/*

Approach with no Extra Space: Do we really need to store all the nodes? Turns out we don't.

We can use the two-pointer tortoise and hare approach.
Set two pointers slow and fast. Advance slow by 1 place and fast by 2 places. If the linked list has a cycle,
these two pointers will be equal at some point. Return true.

However, if fast goes to null or it is the last node in the list and points to null, then there cannot be a cycle,
so return false.

Time Complexity: O(n)

Space Complexity: O(1)

*/
public boolean hasCycle(ListNode head) {

       if(head == null || head.next == null)
           return false;

        ListNode slow = head, fast = head.next;

        while(slow != fast) {

            if(fast == null || fast.next == null)
                return false;

            slow = slow.next;
            fast = fast.next.next;

        }

        return true;
}
