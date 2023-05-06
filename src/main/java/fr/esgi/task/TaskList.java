package fr.esgi.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskList {
    private List<Task> tasks;

    public TaskList(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public Task getTask(Long id){
        Optional<Task> task = tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
        if(task.isPresent()) return task.get();
        else throw new TaskNotFoundException();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void deleteTask(Long id){
        this.tasks.remove(getTask(id));
    }

    public List<Task> getNotDone(){
        return this.tasks.stream().filter(task -> !task.isDone()).collect(Collectors.toList());
    }

    public void markDone(Long id) {
        Optional<Task> task = tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
        if(task.isPresent()) {
            task.get().setDone(true);
        }
        else {
            throw new TaskNotFoundException();
        }
    }

    public static String formatToString(List<Task> tasks){
        StringBuilder str = new StringBuilder();

        for(Task task : tasks){
            str.append(task.toString()).append("\n");
        }

        return str.toString();
    }

    @Override
    public String toString() {
        return formatToString(tasks);
    }
}
