package finalexam;

import java.util.*;

public class F09_BinaryTreeLeftView {
    
  
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
  
    public static TreeNode buildTree(String[] arr) {
        if (arr == null || arr.length == 0) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (i < arr.length) {
            TreeNode node = queue.poll();
            
            if (!arr[i].equals("-1")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(node.left);
            }
            i++;
            
            if (i < arr.length && !arr[i].equals("-1")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(node.right);
            }
            i++;
        }
        
        return root;
    }
    
   
    public static void leftView(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            
          
            for (int i = 1; i <= n; i++) {
                TreeNode node = queue.poll();
                
                if (i == 1) {
                    System.out.print(node.val + " ");
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        
       
        TreeNode root = buildTree(arr);
        
       
        System.out.print("LeftView: ");
        leftView(root);
    }
}
