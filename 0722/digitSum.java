public class digitSum {
    public static int digitSum(int n) {
    if (n == 0) {
        return 0;
    }
    return (n % 10) + digitSum(n / 10);
}

}
