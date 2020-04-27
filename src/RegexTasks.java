import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTasks {
    public static boolean Task1(String inputString) {
        String regex = "[-._[a-zA-Z]]+@[-._[a-zA-Z]]+\\.[a-z]{2,4}";
        return inputString.matches(regex);
    }

    public static boolean Task1_1(String inputString) {
        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
                "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@" +
                "(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:" +
                "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        return inputString.matches(regex);
    }

    public static String Task2(String inputString) {
        String regex = "\\s+,";
        return inputString.replaceAll(regex, ",");
    }

    public static String Task3(String inputString) {
        String regex = "((?U)\\w+)-((?U)\\w+)";
        return inputString.replaceAll(regex, "$2-$1");
    }

    public static int Task4(String inputString) {
        int count = 0;
        String regex = "кот";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static void Task5(String inputFilePath, String outputFilePath) throws IOException {
        String inputText = Files.readString(new File(inputFilePath).toPath(), StandardCharsets.UTF_8);
        String regex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, String.valueOf(Integer.parseInt(matcher.group(1)) + 1));
        }
        matcher.appendTail(sb);
        Files.writeString(new File(outputFilePath).toPath(), sb.toString(), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        String email = "abcd__ef-g@m-ail.com";
        System.out.println("Paragraph 1:");
        System.out.println(RegexTasks.Task1(email));
        System.out.println("Paragraph 1.1:");
        System.out.println(RegexTasks.Task1_1(email));

        String inputString2 = "Это строка  , у которой зачем-то написаны два пробела перед запятой.";
        System.out.println("Paragraph 2:");
        System.out.println(RegexTasks.Task2(inputString2));

        String inputString3 = "Какая-то сине-зеленовая трава";
        System.out.println("Paragraph 3:");
        System.out.println(RegexTasks.Task3(inputString3));

        String inputString4 = "кот КОТ мышь КоТ ПЕС МЫШЬкотМЫШЬ";
        System.out.println("Paragraph 4:");
        System.out.println(RegexTasks.Task4(inputString4));

        try {
            RegexTasks.Task5("InputTask5.txt", "OutputTask5.txt");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

