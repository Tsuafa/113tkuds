package midterm;


import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] games = new int[n];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            games[i] = Integer.parseInt(input[i]);
        }

        int k = Integer.parseInt(sc.nextLine());

        int[] prefixSum = new int[n];
        prefixSum[0] = games[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + games[i];
        }

        System.out.print("PrefixSum:");
        for (int i = 0; i < k; i++) {
            System.out.print(" " + prefixSum[i]);
        }
        System.out.println();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：前綴和陣列建表一次走訪 n 筆比賽資料即可完成，因此時間複雜度為 O(n)。
 */
