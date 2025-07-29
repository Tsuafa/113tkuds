package finalexam;

import java.util.*;

public class F06_ArraySecondLargest {


    static class Pair {
        int max;
        int second;

        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

   
    public static Pair findSecondMax(int[] arr, int left, int right) {
        if (right - left == 1) {
            int a = arr[left], b = arr[right];
            return a > b ? new Pair(a, b) : new Pair(b, a);
        } else if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }

        int mid = (left + right) / 2;
        Pair p1 = findSecondMax(arr, left, mid);
        Pair p2 = findSecondMax(arr, mid + 1, right);

        int max, second;
        if (p1.max > p2.max) {
            max = p1.max;
            second = Math.max(p1.second, p2.max);
        } else {
            max = p2.max;
            second = Math.max(p2.second, p1.max);
        }

        return new Pair(max, second);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每次遞迴將陣列對半切分並合併最大與次大值，所有元素都會被處理一次，總體時間複雜度為 O(n)。
 */
