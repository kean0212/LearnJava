public class StringFormat {
    private int i;
    private long l;
    private float f;
    private double d;

    public StringFormat(int i, long l, float f, double d) {
        this.i = i;
        this.l = l;
        this.f = f;
        this.d = d;
    }

    public String toString() {
        return String.format("%5d %5d %10.2f %10.2f", i, l, f, d);
    }

    public static void main(String[] args) {
        System.out.println(new StringFormat(3, 150, 32.0f, 12.123213));
        System.out.println(new StringFormat(456401, 150123, 12311.12f, 12123123123.123213));
    }

}