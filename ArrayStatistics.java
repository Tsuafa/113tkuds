public class ArrayStatistics {

    public static void main(String[] args) {
        int[] numbers = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        double average = (double) sum / numbers.length;

        int max = numbers[0], min = numbers[0];
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }

        int aboveAverageCount = 0;
        int evenCount = 0, oddCount = 0;
        for (int num : numbers) {
            if (num > average) {
                aboveAverageCount++;
            }
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("＝＝＝ 陣列統計分析結果 ＝＝＝");
        System.out.printf("%-20s %s\n", "總和", sum);
        System.out.printf("%-20s %.2f\n", "平均值", average);
        System.out.printf("%-20s %d (索引 %d)\n", "最大值", max, maxIndex);
        System.out.printf("%-20s %d (索引 %d)\n", "最小值", min, minIndex);
        System.out.printf("%-20s %d\n", "大於平均的數字個數", aboveAverageCount);
        System.out.printf("%-20s %d\n", "偶數個數", evenCount);
        System.out.printf("%-20s %d\n", "奇數個數", oddCount);
    }
}


