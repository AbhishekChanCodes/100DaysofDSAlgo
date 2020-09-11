/*

LeetCode Problem 226

Invert Binary Tree

Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/


/*

Recursive solution :  At each step, instead of swapping the values, we simply change the left and right pointers of the parent node.

Time Complexity: O(n) where n is the number of nodes in the tree.

Space Complexity: O(n) for the recursion call stack

*/

public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return null;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
}




/*

Iterative Solution :  To escape recursion and burdening the call stack, we use a Queue to implement the iterative algorithm.
                      In the beginning, add the root to the queue. If queue is not empty, remove the node, swap it's children
                      and add the children to the queue. Continue this till queue is empty i.e. there are no more children to swap.

Time Complexity: O(n)

Space Complexity: O(n) since each node is added to the queue exactly once.

*/


public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {

        TreeNode current = queue.poll();

        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;

        if (current.left != null)
          queue.add(current.left);

        if (current.right != null)
          queue.add(current.right);
    }
    return root;
}
