public class ExperimentsWithDrawing {

    public static void main(String[] args) {
        System.out.println("Paragraph 1:");
        Drawing first = new Drawing(4, 6, '.');
        first.print();

        System.out.println("Paragraph 4.1:");
        first.drawVerticalLine(5, 'x');
        first.print();
        System.out.println("Paragraph 4.2:");
        first.drawHorizontalLine(1, 'y');
        first.print();

        System.out.println("Paragraph 5:");
        Drawing second = new Drawing(5, 5, '.');
        second.drawRectangle(1, 1, 4, 3, '*');
        second.print();

        System.out.println("Paragraph 7:");
        Drawing third = new Drawing(10, 10, '.');
        third.drawCircle(5, 5, 3, '*');
        third.printForCircle();

        System.out.println("Paragraph 10:");
        Drawing fourth = new Drawing(20, 20, '.');
        Drawing h = house();
        fourth.draw(0, 0, h);
        fourth.print();
    }

    public static Drawing house() {
        Drawing h = new Drawing(20, 20, '.');
        h.drawRectangle(9, 2, 17, 17, '*');
        h.drawCircle(13, 7, 2, '*');
        h.drawRectangle(12, 12, 17, 15, '*');
        h.drawRectangle(5, 1, 9, 18, '*');
        h.drawRectangle(2, 13, 5, 15, '*');
        return h;
    }

}

