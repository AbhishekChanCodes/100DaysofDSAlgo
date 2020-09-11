/*

LeetCode Problem 234

Linked List Palindrome

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?

*/



/*

A quick solution for this is, reverse the Linked List using one of the techniques in the reverseLinkedList Problem
in this folder. Compare the reversed list to the original list. If equal, return true, else false.

If we use the method where we maintain 3 pointers to reverse the list, this problem can be solved in O(n) Time
and O(1) space. 

*/


/*

Stack Solution : Use a stack to store all nodes in the list. Pop and compare to original list. If at any point,
                 the values are not equal, return false.

Time Complexity: O(n)

Space Complexity: O(n)

*/

public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;

        Stack<Integer> stack = new Stack<Integer>();
        ListNode temp = head;

        while(temp!=null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while(!stack.isEmpty()) {
            if(stack.pop() != temp.val)
                return false;
            temp = temp.next;
        }

        return true;
}
