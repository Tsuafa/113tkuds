public class fibonacciSlow {
   public static void main(String[] args) {
    int n = 40;

    long start1 = System.currentTimeMillis();
    System.out.println("Slow: " + fibonacciSlow(n));
    long end1 = System.currentTimeMillis();
    System.out.println("Time (slow): " + (end1 - start1) + " ms");

    int[] memo = new int[n + 1];
    long start2 = System.currentTimeMillis();
    System.out.println("Fast: " + fibonacciFast(n, memo));
    long end2 = System.currentTimeMillis();
    System.out.println("Time (fast): " + (end2 - start2) + " ms");
}


}
