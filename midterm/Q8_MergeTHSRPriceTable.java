package midterm;


import java.util.*;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int n = Integer.parseInt(sc.nextLine());

      
        String[] station = new String[n];
        int[][] price = new int[n][2]; 
       
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            station[i] = input[0];
            price[i][0] = Integer.parseInt(input[1]); 
            price[i][1] = Integer.parseInt(input[2]); 
        }

        
        System.out.printf("%-10s|%-10s|%-10s\n", "Station", "Standard", "Business");

       
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s|%-10d|%-10d\n", station[i], price[i][0], price[i][1]);
        }
    }
}

