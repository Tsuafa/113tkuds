package finalexam;

import java.util.*;

public class F05_LCMRecursive {

    
    public static int gcd(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        else return gcd(a, b - a);
    }

  
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("LCM: " + lcm(a, b));
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：輾轉相減法最壞情況下每次遞迴只減 1，因此最壞需要 O(max(a, b)) 次遞迴，故整體時間複雜度為 O(max(a, b))。
 */
