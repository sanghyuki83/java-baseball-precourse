package baseball;

public class Numbers {
    public int firstNumber;
    public int secondNumber;
    public int thirdNumber;

    public Numbers(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    public Numbers(String str) {
        this.firstNumber = str.charAt(0) - '0';
        this.secondNumber = str.charAt(1) - '0';
        this.thirdNumber = str.charAt(2) - '0';
    }
}
