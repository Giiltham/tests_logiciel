package fr.esgi.task;

public class Task {
    private static long instanceCount = 0;

    private Long id;
    private String description;
    private boolean done;

    public Task(String description){
        instanceCount++;

        this.id = instanceCount;
        this.description = description;
        this.done = false;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean etat) {
        this.done = etat;
    }

    @Override
    public String toString() {
        return  this.id + " | " +
                this.description + " | " +
                (this.done ? "Terminée" : "En cours");
    }
}
