/*

LeetCode Problem 145

Binary Tree Postorder Traversal

Given the root of a binary tree, return the postorder traversal of its nodes' values.

Follow up: Recursive solution is trivial, could you do it iteratively?

Example

Input: root = [1,null,2,3]
Output: [3,2,1]

*/


/*

Recursive solution : It is the same technique as the preorder traversal, with just changing the order of the nodes.

Time Complexity: O(n)

Space Complexity: O(n)

*/

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList();

        if(root == null)
            return result;

        return postOrder(root,result);

    }

    public List<Integer> postOrder(TreeNode node, List<Integer> traversal)
    {
        if(node == null)
            return null;

        postOrder(node.left,traversal);
        postOrder(node.right,traversal);
        traversal.add(node.val);
        return traversal;
    }
}




/*

Iterative Solution : Similar to preOrder traversal, use a stack and just be mindful of the order in which the children
                     onto the stack.

Time Complexity: O(n)

Space Complexity: O(n)

*/


public List<Integer> postorderTraversal(TreeNode root) {

      Stack<TreeNode> stack = new Stack<>();
      List<Integer> postorderTraversal = new ArrayList<>();

      if(root != null) {

	        stack.push(root);

	        while (!stack.isEmpty()) {
		          TreeNode cur = stack.pop();
		          postorderTraversal.addFirst(cur.val);

		          if (cur.left != null)
			           stack.push(cur.left);
                 
		          if (cur.right != null)
			           stack.push(cur.right);
	        }
      }
	    return postorderTraversal;
}
