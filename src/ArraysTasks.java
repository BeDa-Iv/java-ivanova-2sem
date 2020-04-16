import java.util.Arrays;
public class ArraysTasks {
    private static int[] chet(int n){
        int[] array = new int[n+1];
        for (int i=0; i <= n; i++) {
            array[i] = 2*i;
        }
        return array;
    }

    private static boolean hasSimilar(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i] == a[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int srznach(int[] a) {
        int result = 0;
        for (int value : a) {
            result += value;
        }
        return result/a.length;
    }

    private static int[] sortReverse(int[] a) {
        int[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        int temp;
        for (int i = 0; i < copy.length/2; i++) {
            temp = copy[copy.length-i-1];
            copy[copy.length-i-1] = copy[i];
            copy[i] = temp;

        }
        return copy;
    }

    public static void main(String[] args) {
        System.out.println("Paragraph 1:");
        int[] otvet = chet(6);
        for (int value : otvet) {
            System.out.println(value);
        }
        System.out.println("Paragraph 2:");
        int[] res = {1,2,3,2};
        System.out.println(hasSimilar(res));
        System.out.println("Paragraph 3:");
        int[] resultat = {1,2,3,2};
        System.out.println(srznach(resultat));
        System.out.println("Paragraph 4:");
        int[] massiv = {1,5,3,7,4};
        int[] result = sortReverse(massiv);
        for (int value : result) {
            System.out.println(value);
        }
    }
}
