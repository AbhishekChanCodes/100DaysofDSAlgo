/*

LeetCode Problem 700

Search in a Binary Search Tree

Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example,

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2
     / \
    1   3
In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.

*/



/*

Recursive Binary Search - This is essentially binary search with the root being the middle element and the left and right
                         subtrees being the left and right subarrays.

Time Complexity: O(h) where h is the height of the Tree

Space Complexity: O(h) for the recursion call stack

*/

public TreeNode searchBST(TreeNode root, int val) {

        if(root==null)
            return root;

        if(val == root.val)
            return root;
        else if(val < root.val)
            return searchBST(root.left,val);
        else if(val > root.val)
            return searchBST(root.right,val);

        return null;
}


/*

Iterative Binary Search : To save the space cost of recursion, we can write an iterative version of the above algorithm
                          and find the given element.

Time Complexity: O(h) where h is the height of the tree

Space Complexity : O(1)

*/

public TreeNode searchBST(TreeNode root, int val) {

        TreeNode current = root;

        while(current != null && val != current.val)
        {
			       if(val < current.val)
                current = current.left;
             else
                current = current.right;
        }
        return current;
}
