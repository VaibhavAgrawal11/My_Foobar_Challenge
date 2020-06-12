package RE_ID;

public class Solution {
    static String solution(int n) {
        int max = 100700;
        String primeString = "2";
        for (int i = 3; i <= max; i += 2) {
            if (isPrime(i)) {
                primeString = primeString + i;
            }
        }
        String id = primeString.substring(n, n + 5);
        return id;
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
