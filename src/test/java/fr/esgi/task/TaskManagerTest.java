package fr.esgi.task;


import org.mockito.Mock;

public class TaskManagerTest {
    @Mock
    private TaskList taskList;

    private static final TestConsoleManager consoleManager = new TestConsoleManager();
    private static final TaskManager taskManager = new TaskManager(consoleManager);
}
