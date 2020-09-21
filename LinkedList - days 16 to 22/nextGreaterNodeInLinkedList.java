/*

LeetCode Problem 1019

Next Greated Node in Linked List

We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.



Example 1:

Input: [2,1,5]
Output: [5,5,0]


Example 2:

Input: [2,7,4,3,5]
Output: [7,0,5,5,0]


Example 3:

Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]

*/


/*

Approach: Convert the given problem into solving next Greater Element for arrays.
          Convert the Linked List into an ArrayList.
          Use a stack to store the indexes and find the next larger element for the element at each index by comparing it to
          values peeked at from the stack, until we find an element larger than current element, at which point we write the result array at that index
          and move further.

Time Complexity: O(n). We parse through the Linked List once, each index is pushed onto the stack once and we populate
                 the result array as we iterate through the intermediate ArrayList.

Space Complexity: Considering list has N number of nodes.
                  Stack space: O(N)
                  ArrayList space: O(N)
                  Result array space: O(N)

                  So, overall space complexity is of the order of O(N)

*/


public int[] nextLargerNodes(ListNode head) {

        List<Integer> nodes = new ArrayList<Integer>();

        ListNode temp = head;

        while(temp != null) {

            nodes.add(temp.val);
            temp = temp.next;

        }

        int[] result = new int[nodes.size()];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < nodes.size(); i++) {

            while(!stack.isEmpty() && nodes.get(stack.peek()) < nodes.get(i))
                result[stack.pop()] = nodes.get(i);

            stack.push(i);
        }

        return result;
}
