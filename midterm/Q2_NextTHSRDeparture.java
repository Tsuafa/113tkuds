package midterm;
import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];
        String[] timeStrs = new String[n];

        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            timeStrs[i] = time;
            times[i] = toMinutes(time);
        }

        String query = sc.nextLine();
        int queryMin = toMinutes(query);

        int idx = binarySearchNext(times, queryMin);

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(timeStrs[idx]);
        }
    }

   
    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

   
    private static int binarySearchNext(int[] times, int queryMin) {
        int left = 0, right = times.length - 1;
        int ans = times.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryMin) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：利用二分搜尋找出第一個大於查詢時間的班次，搜尋時間為 O(log n)；轉換時間與讀取資料是 O(n)，故主體操作為 O(log n)。
 */
