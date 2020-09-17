/*

Leetcode Problem 328

Odd Even Linked List

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL


Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL


Constraints:

The relative order inside both the even and odd groups should remain as it was in the input.

*/


/*

Approach : Carefully parse through the Linked Lists. You will need to create a separate evenHead for the head of the
           list containing only even nodes. Parse through the odd list, and link the last node of the odd list
           to the evenHead.

           In such a problem, it helps to write down the lists visually and see how you would do the process.

Time Complexity: O(n) where n is the total number of nodes.

Space Complexity: O(1)

*/

public ListNode oddEvenList(ListNode head) {

        if(head == null)
            return null;

        ListNode firsteven = head.next;
        ListNode odd = head, even = head.next;

        while(even != null && even.next != null)
        {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = firsteven;

        return head;
}
