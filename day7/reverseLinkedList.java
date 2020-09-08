/*

LeetCode Problem 206

Reverse Linked List

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

*/



/*

Iterative Approach 1 : Use a stack.

                       Push all nodes onto the stack. Then create a new dummy head and pop the nodes from the Stack
                       and build the reversed linked list.

Time Complexity: O(n)

Space Complexity: O(n)

*/

public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        Stack<ListNode> stack = new Stack<>();

        while(head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        ListNode current;

        while(!stack.isEmpty()) {

            current = stack.pop();
            temp.next = current;
            temp = temp.next;

        }
        temp.next = null;
        return newHead.next;
}


/*

Iterative Approach 2 - Without Extra Space : At each step, maintain three nodes, previousNode, nextNode and currentNode.

Make sure you set nextNode to the next node in the original list, before changing current node to point to it's
previous node.

This is easy to get wrong and make small errors in changing the pointers, so we have to be careful about the 3 pointers.

Time Complexity: O(n)

Space Complexity: O(1)

*/

public ListNode reverseList(ListNode head) {

        ListNode prevNode = null, nextNode = head, temp = head;

        while(temp!=null) {

            temp = nextNode.next;
            nextNode.next = prevNode;
            prevNode = nextNode;
            nextNode = temp;

        }

        return prevNode;
}



/*

Recursive Approach: This algorithm works backwards.
                    Assume the list in front of the current node is already reversed. We just have to make the current node
                    point to it's previous node. That's where the recursion is a bit difficult to understand but very
                    easy to implement.

                    Again, we have to be very careful about the pointers and the links we are changing. It's easy to
                    make an error and mess up the whole list.

Time Complexity: O(n)

Space Complexity: O(n) call stack due to recursion

*/

public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;

}
