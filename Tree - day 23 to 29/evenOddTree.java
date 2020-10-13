/*

LeetCode Problem 1609

Even Odd Tree

A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.

For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).

For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).

Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

*/



/*

Approach: Use Level-Order Traversal. Keep track of the level and define the conditions where we can safely return false
          i.e. the given tree does not fit the definition of the Even Odd Tree.

          For this, we have to check if level and nodes are both even(or odd) OR current node is less than or equal to previous node
          since, at each level, the nodes are in strictly increasing order(for even indexed levels) and in strictly decreasing order
          (for odd indexed levels).

Time Complexity: O(N) where N is the number of nodes in the tree and we visit each node once.

Space Complexity: O(N) for the queue to store the nodes.

*/

public boolean isEvenOddTree(TreeNode root) {

        if(root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int level = 0, prev = 0;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0 ; i < size ; i++){

                TreeNode current = queue.poll();

                if(level % 2 == 0 && (current.val % 2 == 0 || (i > 0 && current.val <= prev)))
                    return false;

                if(level%2 != 0 && (current.val % 2 != 0 || (i > 0 && current.val >= prev))) //odd
                    return false;

                prev = current.val;

                if(current.left != null)
                    queue.add(current.left);

                if(current.right != null)
                    queue.add(current.right);
            }

            level++;
        }

        return true;
}
