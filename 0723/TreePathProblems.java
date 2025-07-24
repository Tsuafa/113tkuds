import java.util.*;

public class TreePathProblems {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }

        path.remove(path.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) return root.val == targetSum;

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }

    public static List<Integer> maxPathSum(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        maxSumHelper(root, 0, new ArrayList<>(), new int[]{Integer.MIN_VALUE}, maxPath);
        return maxPath;
    }

    private static void maxSumHelper(TreeNode node, int currentSum, List<Integer> currentPath,
                                     int[] maxSum, List<Integer> maxPath) {
        if (node == null) return;

        currentSum += node.val;
        currentPath.add(node.val
