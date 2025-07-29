package finalexam;

import java.util.*;

public class F04_TieredIncomeTax {
   
    static int[] brackets = {560000, 1260000, 2520000, 4720000};
    static double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};

    public static int calculateTax(int income) {
        int tax = 0;
        int previous = 0;

        for (int i = 0; i < brackets.length; i++) {
            if (income <= brackets[i]) {
                tax += (income - previous) * rates[i];
                return tax;
            } else {
                tax += (brackets[i] - previous) * rates[i];
                previous = brackets[i];
            }
        }
        
        tax += (income - brackets[brackets.length - 1]) * rates[rates.length - 1];
        return tax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] incomes = new int[n];
        int[] taxes = new int[n];
        int totalTax = 0;

        for (int i = 0; i < n; i++) {
            incomes[i] = sc.nextInt();
            taxes[i] = calculateTax(incomes[i]);
            totalTax += taxes[i];
            System.out.println("Tax: $" + taxes[i]);
        }

        double avg = totalTax / (double) n;
        System.out.printf("Average: $%.1f\n", avg);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆收入在常數時間內計算稅額（級距固定為 5 段），處理 n 筆收入需線性時間，總體時間複雜度為 O(n)。
 */
