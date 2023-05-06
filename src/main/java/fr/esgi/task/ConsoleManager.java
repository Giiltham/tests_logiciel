package fr.esgi.task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleManager implements IConsoleManager {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void write(String value) {
        System.out.print(value);
    }

    @Override
    public void writeLine(String value) {
        System.out.println(value);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public Long readLong() {
        boolean valid = false;
        Long in = null;
        while(!valid){
            try {
                in = scanner.nextLong();
                valid = true;
            }
            catch(InputMismatchException e){
                write("Erreur, vous devez entrer un nombre entier : ");
            }
        }
        return in;
    }
}
