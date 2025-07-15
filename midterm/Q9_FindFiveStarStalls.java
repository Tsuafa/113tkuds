package midterm;

import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        int n = Integer.parseInt(sc.nextLine());
        String[] scores = sc.nextLine().split(" ");

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (Double.parseDouble(scores[i]) == 5.0) {
                count++;
            }
        }

       
        if (count > 0) {
            int[] indices = new int[count];
            int idx = 0;

            
            for (int i = 0; i < n; i++) {
                if (Double.parseDouble(scores[i]) == 5.0) {
                    indices[idx++] = i;
                }
            }

           
            for (int i = 0; i < count; i++) {
                System.out.print(indices[i] + " ");
            }
        } else {
           
            System.out.println("None");
        }
    }
}
