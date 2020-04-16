public class PrimalityTest {
    private static boolean isPrime(int n) {
        int temp;
        for (int i=2; i <= n/2; i++) {
            temp = n % i;
            if (temp == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(3));
        System.out.println(isPrime(18));
    }
}

