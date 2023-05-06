package fr.esgi.task;

public class Main {
    public static void main(String[] args) {
        ConsoleManager consoleManager = new ConsoleManager();
        TaskManager taskManager = new TaskManager(consoleManager);
        taskManager.run();
    }
}
