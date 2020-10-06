/*

LeetCode Problem 116

Populating Next Right Pointers In Each Node

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

*/



/*

Approach: We use the fact that the tree is a complete binary tree i.e. each non-leaf node has both left and right children.
          So, if a node does not have a left child, it means the node is a leaf node. We use this as a terminating condition
          in our recursive approach.

          We keep populating the next pointer for the left child first, and then, after confirming that the right child can
          have a non-null next pointer, we populate it as well.

          Then recursively, we move down the tree and populate the next pointer for all POSSIBLE nodes.

          The solution may look short and simple, but this is a MEDIUM level problem , since you have to mentally keep track of
          3 pointers: left, right and next


Time Complexity: O(N) where N is the number of nodes in the tree. We visit each node once.

Space Complexity: O(1) , since we do not use any extra space. Recursion stack uses up some space.

*/



public Node connect(Node root) {

        if(root == null || root.left == null)
            return;

        root.left.next = root.right;

        if(root.next != null)
            root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);

}
