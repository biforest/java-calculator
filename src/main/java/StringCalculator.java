import java.util.Scanner;

public class StringCalculator {
    public static Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MESSAGE ="문자열을 입력해주세요: ";

    public static void main(String[] args) {
        System.out.print(INPUT_MESSAGE);

        String value = scanner.nextLine();
        String[] values = value.split(" ");

        double num1 = Double.parseDouble(values[0]);

        double result = num1;

        // 문자열 배열 안에서
        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];

            double num2 = Double.parseDouble(values[i + 1]);

            result = Calculator.calculate(result, operator, num2);
        }

        // 최종 결과 출력
        Output.printResult(result);
    }
}