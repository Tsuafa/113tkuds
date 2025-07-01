import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9, 11, 13};
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入數字:");
        int x = scanner.nextInt();
        boolean found = false;

        for (int num : s) {
            if (num == x) {
                found = true;
                break; 
            }
        }

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}

    
