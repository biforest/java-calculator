import java.util.Scanner;

public class Calculator {
    static double calculate(double num1, String operator, double num2) {
        double result = 0;

        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        } else if (operator.equals("/")) {
            result = num1 / num2;
        } else {
            System.out.println("잘못된 기호입니다.");
        }
        return result;
    }

    // main 이름 변경
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = getFirstNum(scanner);

        double result = num1;
        while(true) {
            String operator = getOperator(scanner);

            if (operator.equals("quit")) {
                Output.printResult(result);
                break;
            }

            double second = getSecondNum(scanner);

            result = calculate(result, operator, second);
        }
    }


    // 여기서 부터는
    static double getFirstNum(Scanner scanner) {
        double num1 = scanner.nextDouble();
        return num1;
    }

    static String getOperator(Scanner scanner) {
        String operator = scanner.next();
        return operator;
    }

    static double getSecondNum(Scanner scanner) {
        double num2 = scanner.nextDouble();
        return num2;
    }
}