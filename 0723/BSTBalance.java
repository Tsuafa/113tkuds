public class BSTBalance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class BalanceResult {
        boolean isBalanced;
        int height;

        BalanceResult(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root).isBalanced;
    }

    private static BalanceResult checkBalance(TreeNode node) {
        if (node == null) {
            return new BalanceResult(true, 0);
        }

        BalanceResult left = checkBalance(node.left);
        BalanceResult right = checkBalance(node.right);

        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;

        return new BalanceResult(isBalanced, height);
    }

    public static int getBalanceFactor(TreeNode root) {
        return getBalanceFactorHelper(root);
    }

    private static int getBalanceFactorHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return leftHeight - rightHeight;
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (!isBalanced(root)) {
            return root;
        }

        TreeNode leftUnbalanced = findMostUnbalancedNode(root.left);
        TreeNode rightUnbalanced = findMostUnbalancedNode(root.right);

        return (leftUnbalanced != null) ? leftUnbalanced : rightUnbalanced;
    }

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(1);
        bst.left = new TreeNode(2);
        bst.right = new TreeNode(3);
        bst.left.left = new TreeNode(4);
        bst.left.right = new TreeNode(5);
        bst.left.left.left = new TreeNode(6);

        System.out.println(isBalanced(bst)); 
        System.out.println(getBalanceFactor(bst)); 
        TreeNode unbalancedNode = findMostUnbalancedNode(bst);
        System.out.println(unbalancedNode.val); 
    }
}
