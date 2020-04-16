import java.util.Arrays;
public class TwoDimensionalArrayTask {
    public static char[][] createTable(int size, char symbol){
        char[][] table = new char[size][size];
        for (char[] row: table) {
            Arrays.fill(row, symbol);
        }
        return table;
    }

    public static void printTable(char[][] table){
        for (char[] row : table) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void fillFirstAndLastLines(char[][] table, char symbol){
        Arrays.fill(table[0], symbol);
        Arrays.fill(table[table.length - 1], symbol);
    }

    public static void fillFirstAndLastColumns(char[][] table, char symbol){
        for (char[] row : table) {
            row[0] = symbol;
            row[table.length - 1] = symbol;
        }
    }
}