/*

LeetCode Problem 1302

Deepest Leaves Sum

Given a binary tree, return the sum of values of its deepest leaves.

*/


/*

Approach: Calculate and update the sum at each level. We maintain a queue of nodes for each level.
          At each level, we also calculate the size of the nodes in the previous level and update the sum.
          An important point to remember is to reset the sum back to 0, when we change levels.

          Finally, the sum which we get when the queue becomes empty, is the sum of the deepest leaves.

Time Complexity: O(N) where N is the number of nodes in the tree. We only visit each node once.

Space Complexity: O(N) since we store each node in the queue.

*/


public int deepestLeavesSum(TreeNode root) {

        if(root == null)
            return 0;

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        while(!queue.isEmpty()) {

            sum = 0;
            int size = queue.size();

            while(size-- > 0) {

                TreeNode current = queue.poll();
                sum += current.val;

                if(current.left != null)
                    queue.add(current.left);

                if(current.right != null)
                    queue.add(current.right);

            }
        }
        return sum;
}
