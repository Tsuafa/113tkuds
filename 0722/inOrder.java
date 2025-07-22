public class inOrder {
    public static void inOrder(TreeNode root) {
    if (root == null) {
        return;
    }
    inOrder(root.left);        
    System.out.print(root.val + " "); 
    inOrder(root.right);        

}
