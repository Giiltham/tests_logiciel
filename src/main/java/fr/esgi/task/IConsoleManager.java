package fr.esgi.task;

public interface IConsoleManager {
    void write(String value);
    void writeLine(String value);
    String readLine();
    Long readLong();
}
