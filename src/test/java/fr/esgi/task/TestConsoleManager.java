package fr.esgi.task;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TestConsoleManager implements IConsoleManager{
    private List<String> output;
    private Queue<String> input;

    public TestConsoleManager(){
        output = new ArrayList<>();
        input = new ArrayDeque<>();
    }

    @Override
    public void write(String value) {
        this.output.add(value);
    }

    @Override
    public void writeLine(String value) {
        this.output.add(value + "\n");
    }

    @Override
    public String readLine() {
        return this.input.poll();
    }

    @Override
    public Long readLong() {
        String in = this.input.poll();
        if(in == null) return null;
        return Long.valueOf(in);
    }

    public Queue<String> getInput() {
        return this.input;
    }

    public List<String> getOutput() {
        return this.output;
    }
}
