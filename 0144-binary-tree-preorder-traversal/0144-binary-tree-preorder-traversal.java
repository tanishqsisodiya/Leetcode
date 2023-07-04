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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        while(root!=null || !stack.isEmpty()){
            
            while(root!=null){
                res.add(root.val);
                stack.add(root);
                root = root.left;    
            }
            
            if(stack.isEmpty()){
                return res;
            }
            
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}