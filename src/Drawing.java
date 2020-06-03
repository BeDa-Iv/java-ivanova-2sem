public class Drawing {

    private char[][] picture;
    private int stroka;
    private int stolbets;

    Drawing(int m, int n, char symbol) {
        picture = new char[m][n];
        stolbets = m;
        stroka = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                picture[i][j] = symbol;
        }

    }

    public void print() {
        for (int i = 0; i < stolbets; i++) {
            for (int j = 0; j < stroka; j++) {
                System.out.print(picture[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printForCircle() {
        for (int i = 0; i < stolbets; i++) {
            for (int j = 0; j < stroka; j++) {
                System.out.print(picture[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void drawVerticalLine(int x, char symbol) {
        for (int i = 0; i < stolbets; i++) {
            setPoint(i, x, symbol);
        }
    }

    public void drawHorizontalLine(int y, char symbol) {
        for (int i = 0; i < stroka; i++) {
            setPoint(y, i, symbol);
        }
    }

    public void drawVerticalLine(int y, int x1, int x2, char symbol) {
        for (int i = x1; i <= x2; i++) {
            setPoint(i, y, symbol);
        }
    }

    public void drawHorizontalLine(int x, int y1, int y2, char symbol) {
        for (int i = y1; i <= y2; i++) {
            setPoint(x, i, symbol);
        }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char symbol) {
        this.drawVerticalLine(y1, x1, x2, symbol);
        this.drawVerticalLine(y2, x1, x2, symbol);
        this.drawHorizontalLine(x1, y1, y2, symbol);
        this.drawHorizontalLine(x2, y1, y2, symbol);
    }

    public void drawCircle(int x0, int y0, int r, char symbol) {
        for (int i = x0 - r; i <= x0 + r; i++) {
            for (int j = y0 - r; j <= y0 + r; j++) {
                if (((x0 - i) * (x0 - i)) + ((y0 - j) * (y0 - j)) <= (r * r)) {
                    setPoint(i, j, symbol);
                }
            }
        }
    }

    public void draw(int x, int y, Drawing d) {
        for (int i = 0; i < d.stolbets; i++) {
            for (int j = 0; j < d.stroka; j++) {
                picture[x + i][y + j] = d.picture[i][j];
            }
        }
    }

    private void setPoint(int x, int y, char symbol) {
        picture[x][y] = symbol;
    }

}
