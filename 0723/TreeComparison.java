public class TreeComparison {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val &&
               isIdentical(root1.left, root2.left) &&
               isIdentical(root1.right, root2.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isIdentical(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static TreeNode findLCS(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return null;
        if (isIdentical(root1, root2)) return root1;
        TreeNode left = findLCS(root1.left, root2.left);
        TreeNode right = findLCS(root1.right, root2.right);
        if (left != null && right != null) return root1;
        return left != null ? left : right;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);

        TreeNode tree2 = new TreeNode(2);
        tree2.left = new TreeNode(4);
        tree2.right = new TreeNode(5);

        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(3);
        tree3.left.left = new TreeNode(4);
        tree3.left.right = new TreeNode(6);

        System.out.println(isIdentical(tree1, tree2)); 
        System.out.println(isSubtree(tree1, tree2));  
        TreeNode lcs = findLCS(tree1, tree3);
        printInOrder(lcs); 
    }
}
