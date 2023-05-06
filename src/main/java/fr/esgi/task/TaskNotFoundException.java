package fr.esgi.task;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException() {
        super("La tâche n'a pas été trouvé");
    }
}
