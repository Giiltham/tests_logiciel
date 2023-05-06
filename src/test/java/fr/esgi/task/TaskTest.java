package fr.esgi.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void getIdTest() {
        Task task = new Task("");

        Long id = task.getId();

        assertNotNull(id);
        assertTrue(id > 0);
    }

    @Test
    public void getDescriptionTest() {
        Task task = new Task("");

        assertNotNull(task.getDescription());
        assertEquals(task.getDescription(), "");

        task = new Task("test");

        assertNotNull(task.getDescription());
        assertEquals(task.getDescription(), "test");
    }

    @Test
    public void setDescriptionTest() {
        Task task = new Task("");

        task.setDescription("test");
        assertEquals(task.getDescription(), "test");
    }

    @Test
    public void isDoneTest() {
        Task task = new Task("");
        assertFalse(task.isDone());

        task.setDone(true);
        assertTrue(task.isDone());

        task.setDone(false);
        assertFalse(task.isDone());
    }
}
