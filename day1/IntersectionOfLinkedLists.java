/*

LeetCode Problem 160

Write a program to find the node at which the intersection of two singly linked lists begins.

Constraints:

-> If the two linked lists have no intersection at all, return null.
-> The linked lists must retain their original structure after the function returns.
-> You may assume there are no cycles anywhere in the entire linked structure.

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*

My approach: Use two pointers and point them at the heads of the respective lists. Advance the pointers
             until they become null. Once a pointer becomes null, set it to the head of the other list.

             If there is an intersection, the pointers will meet at which point, our loop will terminate.

             If not, they will reach null and we can return it.



 Time Complexity: O(M + N) where M and N are the lengths of the respective linked lists.

*/



 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;

        ListNode temp1 = headA, temp2 = headB;

        while(temp1 != temp2) {

            temp1 = temp1 == null? headB : temp1.next;
            temp2 = temp2 == null? headA : temp2.next;


        }

        return temp1;

  }
