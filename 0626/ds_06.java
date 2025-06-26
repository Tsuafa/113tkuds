import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random rand = new Random();

        // 產生隨機整數並填入陣列
        System.out.println("產生的陣列元素：");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100); // 產生 0~99 的整數
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // 找出最大值
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println("陣列中的最大值為：" + max);
    }
}
