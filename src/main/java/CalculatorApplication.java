import calculator.Calculator;

public class CalculatorApplication {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("2 + 3 * 4 / 2"));
    }
}