/*

Leetcode Problem 61

Rotate List

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL


Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

*/


/*

Approach: We do an initial parse of the Linked List and we convert it to a cycle i.e. when we encounter the last node,
          we change it's next pointer to the head. We also simultaneously note the length of the list.

          Then we move the pointer ahead by (length - k) places, so we get the starting node of the list after the rotation.
          Aos, we have to clean up our cyclic list and make the next pointer of the previous node as null.

Time Complexity: O(N) where N is the number of the nodes in the list. We parse through the entire list once, and then over (len - k) nodes for a 2nd pass.

Space Complexity: O(1), we don't use any extra space.

*/

public ListNode rotateRight(ListNode head, int k) {

    if(head == null || k == 0) {
        return head;
    }

    ListNode temp = head;
    int len = 1;

    while(temp.next != null) {
        temp = temp.next;
        len++;
    }

    temp.next = head;
    k %= len;

    for(int i = 0; i < len - k; i++) {
        temp = temp.next;
    }

    head = temp.next;
    temp.next = null;
    return head;
}
