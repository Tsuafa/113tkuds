package finalexam;

import java.util.*;

public class F11_BSTClosestValue {

   
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

  
    public static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        
        while (root != null) {
          
            if (Math.abs(target - root.val) < Math.abs(target - closest)) {
                closest = root.val;
            }
            
           
            if (target < root.val) {
                root = root.left;  
            } else {
                root = root.right; 
            }
        }
        
        return closest;
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
        
        int target = sc.nextInt();

        
        int result = closestValue(root, target);
        System.out.println("ClosestValue: " + result);
    }
}
