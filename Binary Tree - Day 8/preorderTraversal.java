/*

LeetCode Problem 144

Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?

*/



/*

Recursive solution : Use a Helper method and recursively add the current node and then it's left and right children to the traversal list.

Time Complexity: O(n)

Space Complexity: O(n) because of recursive call stack

*/

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList();

        if(root==null)
            return result;

        return preOrder(root,result);
    }

    public List<Integer> preOrder(TreeNode node, List<Integer> traversal)
    {
        if(node == null)
            return null;

        traversal.add(node.val);
        preOrder(node.left, traversal);
        preOrder(node.right, traversal);

        return traversal;
    }
}





/*

Iterative Solution using Stack : Initially, push root onto the stack. Then, if stack is not empty, pop and add the node to the traversal list
                                 Then push it's right and left children on to the stack, in that order. It's easy to mess up here.

Time Complexity: O(n)

Space Complexity: O(n) since each node is pushed on to the stack exactly once.

*/

public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preorderTraversal = new ArrayList<>();

        if(root!=null){

            stack.push(root);

            while(!stack.isEmpty()){
                TreeNode curr = stack.pop();
                preorderTraversal.add(curr.val);

                if(curr.right!=null)
                  stack.push(curr.right);

                if(curr.left!=null)
                  stack.push(curr.left);
            }
        }
        return preorderTraversal;
}
