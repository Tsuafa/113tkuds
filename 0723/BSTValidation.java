import java.util.*;

public class BSTValidation {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max))
            return false;

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static List<TreeNode> findInvalidNodes(TreeNode root) {
        List<TreeNode> invalid = new ArrayList<>();
        findInvalid(root, null, null, invalid);
        return invalid;
    }

    private static void findInvalid(TreeNode node, Integer min, Integer max, List<TreeNode> invalid) {
        if (node == null) return;

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            invalid.add(node);
        }

        findInvalid(node.left, min, node.val, invalid);
        findInvalid(node.right, node.val, max, invalid);
    }

    public static int minNodesToRemove(TreeNode root) {
        return countInvalid(root, null, null);
    }

    private static int countInvalid(TreeNode node, Integer min, Integer max) {
        if (node == null) return 0;

        boolean isInvalid = (min != null && node.val <= min) || (max != null && node.val >= max);

        int left = countInvalid(node.left, min, node.val);
        int right = countInvalid(node.right, node.val, max);

        return (isInvalid ? 1 : 0) + left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8); 
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(12); 

        System.out.println(isValidBST(root)); 

        List<TreeNode> invalidNodes = findInvalidNodes(root);
        for (TreeNode node : invalidNodes) {
            System.out.println("Invalid node: " + node.val);
        }

        System.out.println("Minimum nodes to remove: " + minNodesToRemove(root)); 
    }
}
