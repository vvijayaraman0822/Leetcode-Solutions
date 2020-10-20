// 230. Kth Smallest Element in a BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // In order Traversal is sorted
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
           return 0;
        } 
            
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                root = pop.right;
                
                }
            }
        
        return list.get(k-1);
              
        }
}

    
// Better way of solving - no need to fully traverse the tree
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] nums = new int[2];
        inOrderTraversal(root, nums, k);
        
        return nums[1];
    }
    
    public void inOrderTraversal(TreeNode root, int[] nums, int k) {
        if (root == null) {
            return;
        }
        
        inOrderTraversal(root.left, nums, k);
        if (++nums[0] == k) {
            nums[1] = root.val; 
            return;
        }
        inOrderTraversal(root.right, nums, k);
    }
}


    