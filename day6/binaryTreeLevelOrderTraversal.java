/*

LeetCode Problem 102

Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

*/



/*

This is also knows as Breadth-First traversal and is a very popular algorithm and has a number of applications.
We traverse each level and visit it's nodes before moving on to the next level.

A simple trick for Breadth-First and Depth-First traversal is: Use Queue for BFS since Queue can be thought of as
a horizontal data structure and use Stack for DFS since Stack can be thought of a vertical data structure or something
that has depth.

We start from the root and insert both it's left and right children into the queue.
Then we begin constructing our traversal. To ensure for missing children, we calculate the number of nodes at each level
as the size of the queue and to only account for those nodes while building our traversal.

After we have completed a level, pop the nodes, add it to the result and insert it's children into the queue.
Continue this process until the queue is empty.

Time Complexity: O(n) where n is number of nodes in the Tree

Space Complexity: O(n) since each nodes gets stored in the queue exactly once.


*/

public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> result = new ArrayList();

        if(root==null)
            return result;

        Queue<TreeNode> level = new LinkedList();
        TreeNode node = root;
        level.add(root);

        while(!level.isEmpty())
        {
            List<Integer> current = new ArrayList();
            int levelsize = level.size();

            for(int i=0;i<levelsize;i++)
            {
                TreeNode temp = level.remove();
                current.add(temp.val);
                if(temp.left!=null)
                    level.add(temp.left);
                if(temp.right!=null)
                    level.add(temp.right);
            }

            result.add(current);
        }

        return result;
}
