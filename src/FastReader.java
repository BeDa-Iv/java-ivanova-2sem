import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FastReader {
    private static final int shortInterval = 500;
    private static final int longInterval = 1000;
    private static final String regex = ".*[.,;:!?]$";
    private final String inputFilePath;

    public FastReader(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public void Task4() throws FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(new File(inputFilePath));
        while (scanner.hasNext()) {
            String[] words = scanner.nextLine().split("\\s+");
            for (String word : words) {
                System.out.print("\r" + word);
                if (word.matches(regex)) {
                    Thread.sleep(longInterval);
                }
                else {
                    Thread.sleep(shortInterval);
                }
                System.out.flush();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Paragraph 4:");
        FastReader fastReader = new FastReader("InputTask4.txt");
        try {
            fastReader.Task4();
        }
        catch (FileNotFoundException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
