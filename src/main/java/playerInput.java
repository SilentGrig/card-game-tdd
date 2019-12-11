package main.java;

import java.util.Scanner;

public class playerInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public String getInputString() {
        return scanner.nextLine();
    }
}
