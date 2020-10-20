
// 107. Binary Tree Level Order Traversal II

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
 // BFS and reverse the list
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> outputList = new ArrayList<>();
        if (root == null) {
            return outputList;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            List<Integer> innerList = new ArrayList<>();
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                innerList.add(pop.val);
                
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                
                if (pop.right != null) {
                    queue.add(pop.right);
                }
                
            }  
             outputList.add(0, innerList);
        }
        
        return outputList;
        
    }
}