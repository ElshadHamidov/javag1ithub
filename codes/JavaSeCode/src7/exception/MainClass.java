package exception;

class OutOfRangeValueException extends Exception {
    public OutOfRangeValueException(String message) {
        super(message);
    }
}

class CheckRange {
    public void checkValueRange(int value) throws OutOfRangeValueException {
        int min = 10;
        int max = 100;
        if (value < min || value > max) {
            throw new OutOfRangeValueException("Value " + value + " is out of range (" + min + " - " + max + ")");
        } else {
            System.out.println("Dəyər müəyyən aralıqdadır");
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        CheckRange checkRange = new CheckRange();
        try {
            checkRange.checkValueRange(5);
        } catch (OutOfRangeValueException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
