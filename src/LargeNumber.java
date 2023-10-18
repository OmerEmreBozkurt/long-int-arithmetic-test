public class LargeNumber {
    private String longInt;
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

    public Digit getLastDigit() { return lastDigit; }

    public void setLastDigit(Digit lastDigit) {
        this.lastDigit = lastDigit;
    }

    public void getDigits(String value){
        for (int i = 0; i < value.length(); i++) {
            Digit digit = new Digit(value.getBytes()[i] - 48);
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
    public String add(LargeNumber secondInt){
        // there will be a method to make addition
        LargeNumber number1 = new LargeNumber(this.longInt);
        LargeNumber number2 = new LargeNumber(secondInt.longInt);

        if (number1.longInt.length() >= number2.longInt.length()) {
            LargeNumber l = new LargeNumber();
            for (int i = 0; i < number1.longInt.length() ; i++) {

                if (number2.firstDigit != null) {
                    int x = number1.firstDigit.getValue();
                    int y = number2.firstDigit.getValue();

                    if ( x + y >= 10) {
                        if (number1.firstDigit.getNextDigit()==null ) {
                            number1.insertLastDigit(new Digit(0));
                        }
                        int z = number1.firstDigit.getNextDigit().getValue();

                        number1.firstDigit.getNextDigit().setValue  (z + 1);
                        l.insertLastDigit(new Digit ((x + y) % 10));
                    } else {l.insertLastDigit(new Digit (x + y));}

                    number1.deleteFirstDigit();
                    number2.deleteFirstDigit();
                    if (number2.firstDigit == null) {
                        if (number1.getFirstDigit() != null) {
                            l.insertLastDigit(new Digit(number1.getFirstDigit().getValue()));
                            number1.deleteFirstDigit();
                        } else {break;}

                    } else if (number1.firstDigit == null) {break;}

                } else if (number1.firstDigit != null) {
                    l.insertLastDigit(new Digit(number1.getFirstDigit().getValue()));
                    number1.deleteFirstDigit();
                }
            }
            return l.toString();
        } else {return new LargeNumber(number2.longInt).add(new LargeNumber(number1.longInt));}
    }

    public String sub(LargeNumber secondInt){
        // there will be a method to make subtraction
        LargeNumber number1 = new LargeNumber(this.longInt);
        LargeNumber number2 = new LargeNumber(secondInt.longInt);

        if (number1.longInt.length() >= number2.longInt.length()) {
            LargeNumber l = new LargeNumber();

            for (int i = 0; i < number1.longInt.length(); i++) {

                if (number2.firstDigit != null) {
                    int x = number1.getFirstDigit().getValue();
                    int y = number2.getFirstDigit().getValue();

                    if (x < y) {
                        if (number1.firstDigit.getNextDigit() != null) {
                            x = x + 10;
                            number1.firstDigit.getNextDigit().setValue(number1.firstDigit.getNextDigit().getValue() - 1);
                        } else {
                            return "-" + new LargeNumber(number2.longInt).sub(new LargeNumber(number1.longInt));
                        }
                    }

                    l.insertLastDigit(new Digit(x - y));
                    number1.deleteFirstDigit();
                    number2.deleteFirstDigit();

                    if (number2.firstDigit == null) {
                        if (number1.firstDigit != null) {
                            l.insertLastDigit(new Digit(number1.getFirstDigit().getValue()));
                            number1.deleteFirstDigit();
                        } else {
                            break;
                        }
                    } else if (number1.firstDigit == null) {
                        break;
                    }
                } else if (number1.firstDigit != null) {
                    l.insertLastDigit(new Digit(number1.getFirstDigit().getValue()));
                    number1.deleteFirstDigit();
                }
            }
            return l.toString();
        } else {
            return "-" + new LargeNumber(number2.longInt).sub(new LargeNumber(number1.longInt));}
    }
    public String multiply(LargeNumber secondInt){
        // there will be a method to make multiplication
        return null; //this will return a String like longInt
    }
    public String divide(LargeNumber secondInt){
        // there will be a method to make division
        return null; //this will return a String like longInt
    }

    @Override
    public String toString() {
       return "" + firstDigit;
    }
}