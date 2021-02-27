package ui.receiver;

import java.util.Scanner;

public class ConsoleReceiver implements Receiver {

    private final Scanner scanner;

    public ConsoleReceiver() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String receiveExpression() {
        return scanner.nextLine();
    }
}