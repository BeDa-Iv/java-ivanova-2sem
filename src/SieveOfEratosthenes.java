import java.util.Arrays;
public class SieveOfEratosthenes {
    private static boolean[] eratosthene(int n) {

        boolean[] massiv = new boolean[n+1];

        Arrays.fill(massiv, true);
        massiv[0] = false;
        massiv[1] = false;
        for (int i = 2; i < massiv.length; i++) {
            if (massiv[i]) {
                for (int j = 2; i * j < massiv.length; ++j) {
                    massiv[i * j] = false;
                }
            }
        }
        return massiv;
    }

    private static int[] sieve(int n) {
        int count = 0;
        boolean[] result = eratosthene(n);
        for (int i=0; i <= n; i++) {
            if (result[i]) {
                count++;
            }
        }
        int[] array = new int[count];
        int j = 0;
        for (int i=0; i <= n; i++) {
            if (result[i]) {
                array[j] = i;
                j++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println("Paragraph 1:");
        boolean[] res = eratosthene(6);
        for (boolean re : res) {
            System.out.println(re);
        }
        System.out.println("Paragraph 2:");
        int[] result = sieve(5);
        for (int value : result) {
            System.out.println(value);
        }
    }
}
