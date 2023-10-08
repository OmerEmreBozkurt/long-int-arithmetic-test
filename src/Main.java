// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String a = "32567803";
        LargeNumber t = new LargeNumber(a);
        String c = "1234";
        LargeNumber k = new LargeNumber(c);

        String n = null;

        String d = "ab123";
        LargeNumber h = new LargeNumber(d);
        String e = "hcd456";
        LargeNumber g = new LargeNumber(e);
        System.out.println(h.demo(g));

        System.out.println(t);
        System.out.println(k);
        System.out.println(t.add(k));
        System.out.println(k.add(t));



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