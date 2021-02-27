import domain.calculator.Calculator;
import domain.calculator.exception.InvalidInputException;
import domain.expression.operator.exception.DivideByZeroException;
import ui.printer.ConsolePrinter;
import ui.printer.Printer;
import ui.receiver.ConsoleReceiver;
import ui.receiver.Receiver;

import java.util.Optional;

public class CalculatorApplication {
    private static final boolean CONTINUE_PROGRAM = true;
    private static final String EXIT_REQUEST = "exit";

    private Printer printer;
    private Receiver receiver;
    private Calculator calculator;

    public CalculatorApplication() {
        printer = new ConsolePrinter();
        receiver = new ConsoleReceiver();
        calculator = new Calculator();
    }

    public void run() {
        printer.greet();

        while (CONTINUE_PROGRAM) {
            printer.printWaitingForInputText();
            String expression = receiver.receiveExpression();
            if (expression.equalsIgnoreCase(EXIT_REQUEST)) {
                break ;
            }

            Optional<Integer> optionalResult = calculateExpression(expression);
            if (optionalResult.isEmpty()) {
                continue ;
            }

            int result = optionalResult.get();
            printer.printResult(result);
        }
    }

    private Optional<Integer> calculateExpression(String expression) {
        Integer result;
        try {
            result = calculator.calculate(expression);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }

        return Optional.of(result);
    }

    public static void main(String[] args) {
        CalculatorApplication app = new CalculatorApplication();
        app.run();
    }
}