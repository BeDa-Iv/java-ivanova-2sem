import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IOTasks {

    public static void Task1(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        int sum = 0;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
        }
        System.out.println(sum);
    }

    public static void Task1_1(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        int sum = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }
            else {
                scanner.next();
            }
        }
        System.out.println(sum);
    }

    public static void Task2(String[] lines, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath, false);
        for (String line : lines) {
            writer.write(line);
            writer.append(System.lineSeparator());
        }
        writer.flush();
    }

    public static void Task3(String inputFilePath, String outputFilePath) throws IOException {
        Scanner scanner = new Scanner(new File(inputFilePath));
        FileWriter writer = new FileWriter(outputFilePath, false);
        String regex = ".*[.!?]$";
        while (scanner.hasNext()) {
            boolean isFirstWord = true;
            String[] words = scanner.nextLine().split("\\s+");
            for (String word : words) {
                if (isFirstWord) {
                    word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                }
                else {
                    word = word.toLowerCase();
                }
                isFirstWord = Pattern.matches(regex, word);
                writer.write(word);
                writer.append(' ');
            }
            writer.append(System.lineSeparator());
        }
        writer.flush();
    }

    public static void main(String[] args) {
        try {
            System.out.println("Paragraph 1:");
            IOTasks.Task1("InputTask1.txt");
            System.out.println("Paragraph 1.1:");
            IOTasks.Task1_1("InputTask1_1.txt");
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String[] lines = new String[]{"abc", "de", "f"};
        try {
            IOTasks.Task2(lines, "OutputTask2.txt");
            IOTasks.Task3("InputTask3.txt", "OutputTask3.txt");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
