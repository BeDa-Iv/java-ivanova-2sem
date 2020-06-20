import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Transliterator {

    public static final char[] rus = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    public static final String[] eng = new String[]{"a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "ie", "y", "", "e", "iu", "ia"};

    public static Transliterator createICAO_DOC_9303() {
        return new Transliterator(rus, eng);
    }

    private final char[] given;
    private final String[] become;

    public Transliterator(char[] rus, String[] eng) {
        this.given = rus;
        this.become = eng;
    }

    public String translateOneSymbol(char c) {
        int control = -1;
        for (int i = 0; i < given.length; i++) {
            if (Character.toLowerCase(c) == given[i]) {
                control = i;
            }
        }
        if (control == -1) {
            return String.valueOf(c);
        } else if (Character.isUpperCase(c)) {
            return register(become[control]);
        } else {
            return become[control];
        }
    }

    public String translate(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res.append(translateOneSymbol(s.charAt(i)));
        }
        return res.toString();
    }

    public void translateFile(String first, String second) throws IOException {
        String s = Files.readString(Paths.get(first));
        s = translate(s);
        byte[] strToBytes = s.getBytes();
        Files.write(Paths.get(second), strToBytes);
    }

    private String register(String s) {
        if (s.length() < 1) {
            return s;
        } else {
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        }
    }
}
