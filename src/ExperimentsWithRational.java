public class ExperimentsWithRational {
    public static void main(String[] args) {
        Rational ex1 = new Rational(9, 3);
        Rational ex2 = new Rational(7, 2);
        Rational ex3 = new Rational(-3, 11);

        System.out.println(ex1.toString());
        System.out.println(ex2.toString());
        System.out.println(ex3.toString());

        System.out.println(ex1.toDouble());
        System.out.println(ex2.toDouble());
        System.out.println(ex3.toDouble());

        Rational r3 = new Rational(1, 3);
        Rational r2 = new Rational(1, 2);
        Rational r1 = r2.add(r3);
        System.out.println(r1.toString());
        //r2.addInPlace(r3);
        //System.out.println(r2.toString());

        Rational k3 = new Rational(8, 9);
        Rational k2 = new Rational(1, 9);
        Rational k1 = k2.sub(k3);
        System.out.println(k1.toString());
        //p2.subInPlace(p3);
        //System.out.println(p2.toString());

        Rational m3 = new Rational(4, 17);
        Rational m2 = new Rational(7, 3);
        Rational m1 = m2.mul(m3);
        System.out.println(m1.toString());
        //m2.mulInPlace(m3);
        //System.out.println(m2.toString());

        Rational n3 = new Rational(3, 4);
        Rational n2 = new Rational(2, 7);
        Rational n1 = n2.div(n3);
        System.out.println(n1.toString());
        //n2.divInPlace(n3);
        //System.out.println(n2.toString());

        System.out.println(findSum(1));
        System.out.println(findSum(7));
        System.out.println(findSum(20));

        System.out.println(n3.getN());
        System.out.println(n3.getD());
    }

    public static double findSum(int a) {
        double res = 0;
        for (int i = 1; i <= a; i++) {
            res += (double) 1/i;
        }
        return res;
    }
}
