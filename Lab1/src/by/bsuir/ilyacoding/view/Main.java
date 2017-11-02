package by.bsuir.ilyacoding.view;

import by.bsuir.ilyacoding.controller.Controller;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        Controller controller = new Controller();
        String command;
        do {
            System.out.print("> ");
            command = scanner.nextLine();
            System.out.println(controller.doAction(command));
        } while (!command.equals("quit"));
    }
}
