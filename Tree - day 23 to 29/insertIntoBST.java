/*

LeetCode Problem 701

Insert Into A Binary Search Tree

You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

*/


// I am going for an approach, where we do not change the root node.


/*

Recursive Approach: Compare the given value with root, and accordingly, traverse to it's left/right child.
                    Recursively repeat this, until we find a place where we can insert the value.

Time Complexity: O(log n), average case. This becomes O(n) in the worst case.

Space Complexity: Constant space, except for recursion call stack.

*/

public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null)
            return new TreeNode(val);

        if(root.val > val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);

        return root;

}




/*

Iterative Approach: Compare the value of the current node with the given value. If it's less than or equal, then go to
                    right child and find an appropriate spot where you can create a new node and insert it,
                    else, go to the left child and again, find the appropriate spot where you can put the new node.

Time Complexity: O(log n) in average case

Space Complexity: O(1)


*/

public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null)
          return new TreeNode(val);

        TreeNode current = root;

        while(true) {
            if(current.val <= val) {
                if(current.right != null)
                  current = current.right;
                else {
                    current.right = new TreeNode(val);
                    break;
                }
            } else {
                if(current.left != null)
                  current = current.left;
                else {
                    current.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
}
