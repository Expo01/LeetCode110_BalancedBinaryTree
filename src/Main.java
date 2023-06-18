import javax.swing.tree.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode test = new TreeNode() {
        }
    }
}


class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(height(root.left) - height(root.right)) >1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
        //can't just return true but i'm not sure why if the subtrees are not > 1 in height?
    }

    public int height(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}