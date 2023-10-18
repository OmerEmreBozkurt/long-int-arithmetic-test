// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String a = "32567803";
        LargeNumber t = new LargeNumber(a);
        String c = "1234";
        LargeNumber k = new LargeNumber(c);

        String n = null;

        String d = "123";
        LargeNumber h = new LargeNumber(d);
        String e = "456";
        LargeNumber g = new LargeNumber(e);

        System.out.println("h = " + h);
        System.out.println("g = " + g);

        System.out.println("h + g = " + h.add(g));
        System.out.println("g + h = " + g.add(h));

        System.out.println("t = " + t);
        System.out.println("k = " + k);
        System.out.println("t + k = " + t.add(k));
        System.out.println("k + t = " + k.add(t));

        System.out.println("t - k = " + t.sub(k));
        System.out.println("k - t = " + k.sub(t));

        System.out.println("h - g = " + h.sub(g));
        System.out.println("g - h = " + g.sub(h));




       /*
        if (k.getFirstDigit().getNextDigit().getValue() == 0) {
            k.getFirstDigit().getNextDigit().getNextDigit().setValue((byte) (k.getFirstDigit().getNextDigit().getValue() - 1));
            k.getFirstDigit().getNextDigit().setValue((byte) 57);
            k.getFirstDigit().setValue((byte) (k.getFirstDigit().getValue() + 10));
        }
        k.getFirstDigit().getNextDigit().setValue((byte) (k.getFirstDigit().getNextDigit().getValue() - 1));
        k.getFirstDigit().setValue((byte) (k.getFirstDigit().getValue() + 10));

        System.out.println(k);
        */
    }


}