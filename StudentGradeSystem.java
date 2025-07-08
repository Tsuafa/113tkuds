public class StudentGradeSystem {

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        char[] grades = new char[scores.length];

        int total = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        int countA = 0, countB = 0, countC = 0, countD = 0;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            total += score;

            if (score >= 90) {
                grades[i] = 'A';
                countA++;
            } else if (score >= 80) {
                grades[i] = 'B';
                countB++;
            } else if (score >= 70) {
                grades[i] = 'C';
                countC++;
            } else {
                grades[i] = 'D';
                countD++;
            }

            if (score > max) {
                max = score;
                maxIndex = i;
            }
            if (score < min) {
                min = score;
                minIndex = i;
            }
        }

        double average = (double) total / scores.length;
        int countAboveAvg = 0;

        for (int score : scores) {
            if (score > average) {
                countAboveAvg++;
            }
        }

        double percentAboveAvg = (double) countAboveAvg / scores.length * 100;

        System.out.println("＝＝＝＝ 學生成績報告系統 ＝＝＝＝");
        System.out.println("------------------------------------");
        System.out.printf("全班平均分數：%.2f\n", average);
        System.out.println("最高分：" + max + "，學生編號：" + (maxIndex + 1));
        System.out.println("最低分：" + min + "，學生編號：" + (minIndex + 1));
        System.out.println("等級統計：A=" + countA + " B=" + countB + " C=" + countC + " D=" + countD);
        System.out.printf("高於平均的學生比例：%.1f%%\n", percentAboveAvg);
        System.out.println("------------------------------------");
        System.out.printf("%-6s %-6s %-6s\n", "編號", "分數", "等級");
        System.out.println("------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-6d %-6d %-6c\n", (i + 1), scores[i], grades[i]);
        }

        System.out.println("------------------------------------");
    }
}


