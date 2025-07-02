import java.util.Scanner;

public class q7permutation {
    static int ops = 0;
    static int[] arr;
    static boolean[] used;
    static int n;

    public static void backtrack(int depth, int[] perm) {
        ops++;
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(perm[i]);
                if (i < n - 1) System.out.print(" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = arr[i];
                backtrack(depth + 1, perm);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;
        used = new boolean[n];
        backtrack(0, new int[n]);
        System.out.println(ops);
    }
}
