public class Main {
    public static void main(String[] args) {

        LargeNumber a = new LargeNumber("8000000");
        LargeNumber b = new LargeNumber("2");

        System.out.println(a.divide(b));
        a.sub(b);
        a.multiply(b);


    }


}