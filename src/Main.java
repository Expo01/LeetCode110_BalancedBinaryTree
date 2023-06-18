import javax.swing.tree.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode test = new TreeNode() {
        }
    }
}

/* youtube version, double recursion, overly complicated

 */
//class Solution {
//    public boolean isBalanced(TreeNode root) {
//        if(root == null) return true;
//        if(Math.abs(height(root.left) - height(root.right)) >1) return false;
//        return isBalanced(root.left) && isBalanced(root.right);
//        // can't just return true but i'm not sure why if the subtrees are not > 1 in height?
//    }
//
//    public int height(TreeNode node) {
//        if(node == null) return 0;
//        return 1 + Math.max(height(node.left), height(node.right));
//    }
//}


// TOP LEETCOTEE
class Solution{
    public boolean isBalanced(TreeNode root) {
        if (root == null)  return true;
        if (heightIfBalanced(root) == -1)  return false;
        return true;
    }

    public int heightIfBalanced(TreeNode root) {
        if (root == null)  return 0;
        int leftHeight = heightIfBalanced(root.left);
        int rightHeight = heightIfBalanced(root.right);
        if (leftHeight == -1 || rightHeight == -1)  return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)  return -1; // this will return '-1' to either 'leftHeight' or
        // 'rightHeight' and then run the || line and recursively rreturn -1 to all preceding || conditions  until last
        // item onn stack returns -1 back to main wheere is Height(root) == -1 then isBalanced returns false.
        return Math.max(leftHeight, rightHeight) + 1; // if no subtree unbalancd in a node, then return +1
        // starting with nulls found so null + 1 = 1, --> 1+1 = 2, etc. all the way to bottom of call stack and a non
        // negative value is returned. this could also be useful where we neeed to find max depth such that connditions
        // checking for balance woudn't be needed
    }
}
