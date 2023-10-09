public class LargeNumber {
    private String longInt;

    /*private Digit[] Digits; //All digits of long int will be stored in an Array
    */

    private Digit firstDigit;
    private Digit lastDigit;


    public LargeNumber (String longInt){
        this.longInt = longInt;
        getDigits(longInt);
    }

    public LargeNumber (Digit firstDigit){
        insertFirstDigit(firstDigit);
    }

    public LargeNumber(){
        this.firstDigit = null;
        this.lastDigit = null;
    }

    public boolean isEmpty(){
        return firstDigit == null;
    }

    public Digit getFirstDigit() {
        return firstDigit;
    }

    public void setFirstDigit(Digit firstDigit) {
        this.firstDigit = firstDigit;
    }

    public Digit getLastDigit() {
        return lastDigit;
    }

    public void setLastDigit(Digit lastDigit) {
        this.lastDigit = lastDigit;
    }

    public void getDigits(String value){
        for (int i = 0; i < longInt.length(); i++) {
            Digit digit = new Digit(longInt.getBytes()[i] - 48);
            if (digit.getValue() > 9 || digit.getValue() < 0) {
                throw new RuntimeException("Please provide valid integers.");
            } else {
                insertFirstDigit(digit);
            }
        }
    }


    public void insertFirstDigit(Digit digit){
        if (firstDigit == null) {
            lastDigit = digit;
        }
        digit.setNextDigit(firstDigit);
        firstDigit = digit;
    }

    public void deleteFirstDigit(){
        firstDigit = firstDigit.getNextDigit();
        if (isEmpty()){
            lastDigit = null;
        }
    }

    public void insertLastDigit(Digit digit){
        if (firstDigit == null) {
            firstDigit = digit;
        } else {
            lastDigit.setNextDigit(digit);
        }
        lastDigit = digit;
    }

    public String demo(LargeNumber secondInt){
        if (this.longInt.length() >= secondInt.longInt.length()) {

            return this.longInt + secondInt.longInt;
        } else {
            return secondInt.demo(this);
        }
    }

    public String add(LargeNumber secondInt){
        // there will be a method to make addition
        if (this.longInt.length() >= secondInt.longInt.length()) {
            LargeNumber l = new LargeNumber();
            for (int i = 0; i < longInt.length() ; i++) {

                if (secondInt.firstDigit != null) {
                    int x = this.firstDigit.getValue();
                    int y = secondInt.firstDigit.getValue();

                    if ( x + y >= 10) {
                        if (this.firstDigit.getNextDigit()==null ) {
                            this.insertLastDigit(new Digit(0));
                        }
                        int z = this.firstDigit.getNextDigit().getValue();

                        this.firstDigit.getNextDigit().setValue  (z + 1);
                        l.insertLastDigit(new Digit ((x + y) % 10));
                    } else {l.insertLastDigit(new Digit (x + y));}

                    this.deleteFirstDigit();
                    secondInt.deleteFirstDigit();
                    if (secondInt.firstDigit == null) {
                        if (this.getFirstDigit() != null) {
                            l.insertLastDigit(new Digit(this.getFirstDigit().getValue()));
                            this.deleteFirstDigit();
                        } else {
                            break;
                        }
                    } else if (this.firstDigit == null) {
                        break;
                    }
                } else if (this.firstDigit != null) {
                    l.insertLastDigit(new Digit(this.getFirstDigit().getValue()));
                    this.deleteFirstDigit();
                }
            }
            return l.toString();
        } else {return new LargeNumber(secondInt.longInt).add(new LargeNumber(this.longInt));}
    }

    public String sub(LargeNumber longInt2){
        // there will be a method to make subtraction
        return null; //this will return a String like longInt
    }
    public String multiply(LargeNumber longInt2){
        // there will be a method to make multiplication
        return null; //this will return a String like longInt
    }
    public String divide(LargeNumber longInt2){
        // there will be a method to make division
        return null; //this will return a String like longInt
    }

    @Override
    public String toString() {
        return "" + firstDigit;
    }
}