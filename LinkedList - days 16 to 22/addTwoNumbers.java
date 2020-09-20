/*

LeetCode Problem 2

Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/


/*

Approach: Perform the mathematical calculation step by step. We need a new Linked List, since there is a possibility
          that our result will have more digits than the original numbers because of carry.

          We have to be careful of the situations where 1 number has no more nodes and the other list still has nodes.

Time Complexity: If M and N are the number of digits in the two numbers, then time complexity will be O(max(M,N))

Space Complexity: O(max(M,N)). 

*/

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while(l1 != null || l2 != null) {

            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;

            int sum = num1 + num2 + carry;
            carry = sum/10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if(l1 != null)
                l1 = l1.next;

            if(l2 != null)
                l2 = l2.next;

        }

        if(carry > 0)
            current.next = new ListNode(carry);

        return dummy.next;
}
