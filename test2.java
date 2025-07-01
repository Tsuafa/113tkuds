import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9, 11, 13};
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入要查找的數字：");
        int x = scanner.nextInt();

        int left = 0, right = s.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (s[mid] == x) {
                found = true;
                break;
            } else if (s[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (found) {
            System.out.println("數字 " + x + " 存在於陣列中。");
        } else {
            System.out.println("數字 " + x + " 不存在於陣列中。");
        }

        scanner.close();
    }
}

