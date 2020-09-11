/*

LeetCode Problem 94

Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

*/



/*

Recursive Solution : Once again, the recursive solution is very similar to preorder and postorder. Just the order in which
                     the nodes are written changes.

Time Complexity: O(n)

Space Complexity: O(n)

*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList();

        if(root==null)
            return result;

        return inOrder(root,result);

    }

    public List<Integer> inOrder(TreeNode node, List<Integer> traversal)
    {
        if(node == null)
            return null;

        inOrder(node.left,traversal);
        traversal.add(node.val);
        inOrder(node.right,traversal);
        return traversal;
    }
}



/*

Iterative Solution: Use stack. However, it is a little different. First, we have to push the entire left subtree onto the Stack
                    Then pop each node one by one, add it to the traversal and then travel to the right child.

Time Complexity: O(n)

Space Complexity: O(n)

*/

public List <Integer> inorderTraversal(TreeNode root) {

        Stack <TreeNode> stack = new Stack < > ();
        List <Integer> inorderTraversal = new ArrayList <>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            inorderTraversal.add(current.val);
            current = current.right;
        }
        return inorderTraversal;
}
