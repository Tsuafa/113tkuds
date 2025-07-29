package finalexam;

import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        String start = sc.next();
        String end = sc.next();

        int idxStart = -1, idxEnd = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                idxStart = i;
            }
            if (stops[i].equals(end)) {
                idxEnd = i;
            }
        }

        if (idxStart == -1 || idxEnd == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(idxStart - idxEnd) + 1);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：需一次掃描 n 個停靠站來找出起訖站的索引位置，因此為線性時間複雜度。
 */

