package finalexam;

import java.util.*;

public class F12_TreeDiameter {

  
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

   
    public static int[] diameter(TreeNode root) {
        int[] result = new int[2]; 
        
      
        helper(root, result);
        
        return result;
    }

   
    public static int helper(TreeNode node, int[] result) {
        if (node == null) return 0;
        
     
        int leftHeight = helper(node.left, result);
        int rightHeight = helper(node.right, result);
        
       
        result[0] = Math.max(result[0], leftHeight + rightHeight);
        
       
        return Math.max(leftHeight, rightHeight) + 1;
    }

   
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        
       
        TreeNode root = null;
        for (String val : input) {
            root = insert(root, Integer.parseInt(val));
        }
        
       
        int[] result = diameter(root);
        System.out.println("Diameter: " + result[0]);
    }
}
