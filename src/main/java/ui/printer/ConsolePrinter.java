package ui.printer;

public class ConsolePrinter implements Printer {
    private final String GREET_MESSAGE = "계산기 프로그램입니다.\n" +
            "숫자와 사칙연산 기호를 공백으로 구분하여 입력해주세요.\n" +
            "프로그램을 종료하시려면 exit을 입력해주세요.";

    private final String INPUT_REQUEST_MESSAGE = "식 입력: ";

    private final String OUTPUT_MESSAGE = "answer: %d\n";
    private final String EXIT_MESSAGE = "프로그램을 종료합니다.";

    @Override
    public void greet() {
        System.out.println(GREET_MESSAGE);
    }

    @Override
    public void printWaitingForInputText() {
        System.out.println(INPUT_REQUEST_MESSAGE);
    }

    @Override
    public void printResult(int result) {
        System.out.printf(OUTPUT_MESSAGE, result);
    }

    @Override
    public void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }
}
