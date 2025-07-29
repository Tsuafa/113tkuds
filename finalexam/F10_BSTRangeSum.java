package finalexam;

import java.util.*;

public class F10_BSTRangeSum {
    
   
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

   
    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        
        int sum = 0;
        
       
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        
        
        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R); 
        }
        
        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }
        
        return sum;
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
        
        int L = sc.nextInt();
        int R = sc.nextInt();

      
        int result = rangeSumBST(root, L, R);
        System.out.println("RangeSum: " + result);
    }
}
