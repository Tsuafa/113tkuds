package midterm;


import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int total = 0;
        for (int i = 0; i < n; i++) {
            int kWh = Integer.parseInt(sc.nextLine());
            int bill = calc(kWh);
            total += bill;
            System.out.println("Bill: $" + bill);
        }

        int avg = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }


    private static int calc(int kWh) {
        double cost = 0;

        int[] limits = {120, 330, 500, 700, 1000};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        int[] ranges = new int[6];

        ranges[0] = Math.min(kWh, limits[0]);
        if (kWh > limits[0]) ranges[1] = Math.min(kWh, limits[1]) - limits[0];
        if (kWh > limits[1]) ranges[2] = Math.min(kWh, limits[2]) - limits[1];
        if (kWh > limits[2]) ranges[3] = Math.min(kWh, limits[3]) - limits[2];
        if (kWh > limits[3]) ranges[4] = Math.min(kWh, limits[4]) - limits[3];
        if (kWh > limits[4]) ranges[5] = kWh - limits[4];

        for (int i = 0; i < 6; i++) {
            cost += ranges[i] * rates[i];
        }

        return (int) Math.round(cost);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：主程式走訪每筆用電資料並呼叫 calc()，每次 calc() 內部處理為常數操作（最多 6 段），故總體為 O(n)，n 為用電戶數。
 */
