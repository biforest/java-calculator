package calculator;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();

        Input input = new Input(operation);
        List<Integer> operands = input.getOperands();
        List<Character> operators = input.getOperators();

        Calculator calculator = new Calculator();
        double result = calculator.calculate(operands, operators);
        System.out.println("result = " + result);
    }
}
