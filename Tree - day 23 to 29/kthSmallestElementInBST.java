/*

LeetCode Problem  230

Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1


Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

*/




/*

Iterative Approach: Use a helper function to calculate the inorder traversal of the BST and write it to a list.
                    Once the traversal is done, we need the (k-1)th element from the traversal as our answer.

Time Complexity: O(N) for the inorder traversal, where N is number of nodes in the BST.

Space Complexity: O(N) for storing the traversal.

*/

class Solution {
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> nodes = new ArrayList<Integer>();
        nodes = traversal(root, nodes);
        return nodes.get((k - 1));
    }

    public List<Integer> traversal(TreeNode root, List<Integer> nodes) {

        if(root == null)
            return nodes;

        traversal(root.left, nodes);
        nodes.add(root.val);
        traversal(root.right, nodes);
        return nodes;
    }
}



/*

Iterative version: Use a stack to eliminate recursion. Also, we don't need to calculate the entire traversal.
                   Once we are done with the first k nodes, we know that the next node will be our answer.
                   We use this to minimize the number of calculations.

Time Complexity: O(N) where N is the number of nodes in the BST.

Space Complexity: O(N) for storing nodes on stack.

*/


public int kthSmallest(TreeNode root, int k) {

      Stack<TreeNode> nodes = new Stack<>();

      while (root != null) {

          nodes.push(root);
          root = root.left;
      }

      while (k != 0) {

          TreeNode temp = nodes.pop();
          k--;
          if (k == 0)
            return temp.val;

          TreeNode nextNode = temp.right;
          while (nextNode != null) {
              nodes.push(nextNode);
              nextNode = nextNode.left;
          }
      }

      return Integer.MAX_VALUE;
}
