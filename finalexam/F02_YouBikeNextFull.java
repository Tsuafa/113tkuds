package finalexam;

import java.util.*;

public class F02_YouBikeNextFull {
    // 時間轉換成總分鐘數
    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] schedule = new int[n];
        String[] originalTimes = new String[n];

        for (int i = 0; i < n; i++) {
            originalTimes[i] = sc.nextLine();
            schedule[i] = timeToMinutes(originalTimes[i]);
        }

        String query = sc.nextLine();
        int queryMinutes = timeToMinutes(query);

        // Binary Search
        int left = 0, right = n - 1, answerIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (schedule[mid] > queryMinutes) {
                answerIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (answerIndex == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(originalTimes[answerIndex]);
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋在已排序時間表中找出首個大於查詢值的時刻，時間複雜度為 O(log n)。
 */
