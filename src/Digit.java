public class Digit {
    private int value;
    private Digit nextDigit = null;

    public Digit(int value) {
        //There will be a constructor for Digit Class
        this.value = value;
        this.nextDigit = null;
    }


    public int getValue() {
        return value;
    }

    public Digit getNextDigit() {
        return nextDigit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNextDigit(Digit nextDigit) {
        this.nextDigit = nextDigit;
    }

    @Override
    public String toString() {
        if (nextDigit == null){
            return "" + value;
        } else {
        return ""+ nextDigit + value;
        }
    }
}