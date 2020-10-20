// 102. Binary Tree Level Order Traversal

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
// Level Order Traversal, same as breadth first search algorithm 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outputList = new ArrayList<>();
         if(root == null) {
            return outputList;
        }
        
        Queue<TreeNode> queue = new LinkedList<>(); // BFS using a Queue
        queue.add(root);
         
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode pop = new TreeNode();
            List<Integer> innerList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                pop = queue.poll();
                innerList.add(pop.val);     
                
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                
                if (pop.right != null) {
                    queue.add(pop.right);
                } 
            }
            
            outputList.add(innerList);
            
        }
        
        return outputList;
        
    }
}