package fr.esgi.task;


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
        Task task1 = taskList.getTask(1L);
        Task task2 = taskList.getTask(2L);

        assertEquals(task1.getDescription(), "test 1");
        assertEquals(task1.getId(), 1L);

        assertEquals(task2.getDescription(), "test 2");
        assertEquals(task2.getId(), 2L);
    }

    @Test
    @Order(3)
    public void MarkDoneTest(){
        taskList.markDone(1L);
        List<Task> tasks = taskList.getTasks();

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
        taskList.deleteTask(1L);

        List<Task> tasks = taskList.getTasks();
        assertEquals(tasks.size(), 1);
        assertEquals(tasks.get(0).getId(), 2L);

        taskList.deleteTask(2L);
        assertTrue(tasks.isEmpty());
    }

}
