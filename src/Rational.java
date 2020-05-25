public class Rational {
    private static final Rational ZERO = new Rational(0);
    private static final Rational ONE = new Rational(1);
    private int n;
    private int d;

    public static Rational add(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.d + r2.n * r1.d, r2.d * r1.d);
    }

    public static Rational sub(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.d - r2.n * r1.d, r2.d * r1.d);
    }

    public static Rational mul(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.n, r2.d * r1.d);
    }

    public static Rational div(Rational r1, Rational r2) {
        return new Rational(r1.n * r2.d, r2.n * r1.d);
    }

    private static int gcd(int m, int n) {
        if (0 == n) { return m; }
        else return gcd(n, m % n);
    }

    public Rational (int n, int d) {
        if (d == 0) {
            throw new ArithmeticException("denominator is zero");
        }
        int mygcd = gcd (n, d);
        n = n / mygcd;
        d = d / mygcd;
        if (d < 0) {
            d = -d;
            n = -n;
        }
        this.n = n;
        this.d = d;
    }

    public Rational (int n) {
        this.n = n;
        this.d = 1;
    }

    public long getN() {
        return n;
    }

    public long getD() {
        return d;
    }

    public String toString() {
        if (d == 1) {
            return (this.n + "");
        }
        else {
            return (this.n + "/" + this.d);
        }
    }

    public double toDouble() { return (double) n / d; }

    public Rational add(Rational r) {
        return new Rational(n * r.d + r.n * d, r.d * d);
    }

  /*  public void addInPlace(Rational r) {
        n = n * r.d + r.n * d;
        d = r.d * d;
        int mygcd = gcd (n, d);
        n = n / mygcd;
        d = d / mygcd;
        if (d < 0) { d = -d; n = -n; }
        this.n = n;
        this.d = d;
    } */

    public Rational sub(Rational r) {
        return new Rational(n * r.d - r.n * d, r.d * d);
    }

   /*  public void subInPlace(Rational r) {
        n = n * r.d - r.n * d;
        d = r.d * d;
        int mygcd = gcd (n, d);
        n = n / mygcd;
        d = d / mygcd;
        if (d < 0) { d = -d; n = -n; }
        this.n = n;
        this.d = d;
    } */

    public Rational mul(Rational r) {
        return new Rational(n * r.n, r.d * d);
    }

  /*  public void mulInPlace(Rational r) {
        n = n * r.n;
        d = r.d * d;
        int mygcd = gcd (n, d);
        n = n / mygcd;
        d = d / mygcd;
        if (d < 0) { d = -d; n = -n; }
        this.n = n;
        this.d = d;
    } */

    public Rational div(Rational r) {
        return new Rational(n * r.d, r.n * d);
    }

 /*    public void divInPlace(Rational r) {
        n = n * r.d;
        d = r.n * d;
        int mygcd = gcd (n, d);
        n = n / mygcd;
        d = d / mygcd;
        if (d < 0) { d = -d; n = -n; }
        this.n = n;
        this.d = d;
    } */

}
