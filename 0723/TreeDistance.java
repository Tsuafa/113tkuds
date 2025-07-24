public class TreeDistance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int getDistance(TreeNode root, TreeNode node1, TreeNode node2) {
        TreeNode lca = findLCA(root, node1, node2);
        return getDistanceFromLCA(lca, node1) + getDistanceFromLCA(lca, node2);
    }

    private static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        TreeNode left = findLCA(root.left, node1, node2);
        TreeNode right = findLCA(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }

    private static int getDistanceFromLCA(TreeNode root, TreeNode node) {
        if (root == null) return -1;
        if (root == node) return 0;
        int left = getDistanceFromLCA(root.left, node);
        int right = getDistanceFromLCA(root.right, node);

        if (left == -1 && right == -1) return -1;
        return Math.max(left, right) + 1;
    }

    public static int getDiameter(TreeNode root) {
        int[] maxDiameter = new int[1];
        getDiameterHelper(root, maxDiameter);
        return maxDiameter[0];
    }

    private static int getDiameterHelper(TreeNode root, int[] maxDiameter) {
        if (root == null) return 0;

        int leftHeight = getDiameterHelper(root.left, maxDiameter);
        int rightHeight = getDiameterHelper(root.right, maxDiameter);

        maxDiameter[0] = Math.max(maxDiameter[0], leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void findNodesAtDistance(TreeNode root, int distance) {
        findNodesAtDistanceHelper(root, distance);
    }

    private static void findNodesAtDistanceHelper(TreeNode root, int distance) {
        if (root == null) return;

        if (distance == 0) {
            System.out.print(root.val + " ");
            return;
        }

        findNodesAtDistanceHelper(root.left, distance - 1);
        findNodesAtDistanceHelper(root.right, distance - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode node1 = root.left.left;
        TreeNode node2 = root.right.right; 
        System.out.println(getDistance(root, node1, node2)); 

        System.out.println(getDiameter(root)); 

        System.out.print("Nodes at distance 2 from root: ");
        findNodesAtDistance(root, 2); 
    }
}
