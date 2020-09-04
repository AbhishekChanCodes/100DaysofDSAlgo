/*

LeetCode Problem 19

Remove Nth Node From End of List

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the 2nd node from the end, the linked list becomes 1->2->3->5.

*/



/*

The solution to this problem is easy if you do two passes. In the 1st pass, calculate the length of the linked list.
In the next pass, you can find the nth node from the end and remove it.

One-pass solution: Two-pointer technique.

Initialize two pointers fast and slow to head. Move fast pointer ahead by n places.
Now move both pointers ahead by 1 until fast reaches the end. Because the distance between the two pointers is n,
the slow pointer will point towards the nth node from end of the list. Remove it.

Time Complexity: O(n)


*/



public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode temp = new ListNode(0);
    ListNode fast = temp;
    ListNode slow = temp;
    temp.next = head;

    for (int i = 1; i <= n + 1; i++) {
        fast = fast.next;
    }
    
    while (fast != null) {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return temp.next;
}
