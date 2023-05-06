package fr.esgi.task;


import org.junit.Before;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskListTest {

    private static final TaskList taskList = new TaskList();

    @Test
    @Order(1)
    public void addTaskTest(){

        Task task1 = new Task("test 1");
        Task task2 = new Task("test 2");

        taskList.addTask(task1);
        taskList.addTask(task2);

        List<Task> tasks = taskList.getTasks();

        assertNotNull(tasks);

        assertEquals(task1, tasks.get(0));
        assertEquals(task2, tasks.get(1));
    }

    @Test
    @Order(2)
    public void getTaskTest(){
        List<Task> tasks = taskList.getTasks();
        Task task1 = taskList.getTask(tasks.get(0).getId());
        Task task2 = taskList.getTask(tasks.get(1).getId());

        assertEquals(task1.getDescription(), "test 1");
        assertEquals(task2.getDescription(), "test 2");
    }

    @Test
    @Order(3)
    public void MarkDoneTest(){
        List<Task> tasks = taskList.getTasks();

        taskList.markDone(tasks.get(0).getId());

        assertTrue(tasks.get(0).isDone());
        assertFalse(tasks.get(1).isDone());
    }

    @Test
    @Order(4)
    public void formatToStringTest(){

    }

    @Test
    @Order(5)
    public void deleteTaskTest(){
        List<Task> tasks = taskList.getTasks();

        Long id = tasks.get(1).getId();

        taskList.deleteTask(tasks.get(0).getId());
        assertEquals(tasks.size(), 1);
        assertEquals(taskList.getTask(id).getId(), tasks.get(0).getId());

        taskList.deleteTask(tasks.get(0).getId());
        assertTrue(tasks.isEmpty());
    }

}
