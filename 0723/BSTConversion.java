public class BSTConversion {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class DoublyListNode {
        int val;
        DoublyListNode prev, next;
        DoublyListNode(int val) {
            this.val = val;
        }
    }

   
    static DoublyListNode prev = null, head = null;

    public static DoublyListNode bstToDoublyList(TreeNode root) {
        prev = null;
        head = null;
        inOrderConvert(root);
        return head;
    }

    private static void inOrderConvert(TreeNode node) {
        if (node == null) return;

        inOrderConvert(node.left);

        DoublyListNode curr = new DoublyListNode(node.val);
        if (prev != null) {
            prev.next = curr;
            curr.prev = prev;
        } else {
            head = curr;
        }
        prev = curr;

        inOrderConvert(node.right);
    }

   
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBalancedBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBalancedBST(nums, left, mid - 1);
        node.right = buildBalancedBST(nums, mid + 1, right);
        return node;
    }

  
    static int sum = 0;

    public static void convertToGreaterTree(TreeNode root) {
        sum = 0;
        reverseInOrder(root);
    }

    private static void reverseInOrder(TreeNode node) {
        if (node == null) return;
        reverseInOrder(node.right);
        sum += node.val;
        node.val = sum;
        reverseInOrder(node.left);
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void printDoublyList(DoublyListNode head) {
        DoublyListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 測試功能 1
        TreeNode bst = new TreeNode(4);
        bst.left = new TreeNode(2);
        bst.right = new TreeNode(5);
        bst.left.left = new TreeNode(1);
        bst.left.right = new TreeNode(3);
        DoublyListNode listHead = bstToDoublyList(bst);
        printDoublyList(listHead); 

        
        int[] sorted = {-10, -3, 0, 5, 9};
        TreeNode balancedBST = sortedArrayToBST(sorted);
        printInOrder(balancedBST);
        System.out.println();

       
        TreeNode bst2 = new TreeNode(5);
        bst2.left = new TreeNode(2);
        bst2.right = new TreeNode(13);
        convertToGreaterTree(bst2);
        printInOrder(bst2); 
    }
}
