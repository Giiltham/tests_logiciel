package fr.esgi.task;


import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TaskManagerTest {

    private static IConsoleManager consoleManagerMock;

    @BeforeEach
    public void beforeEach(){
        consoleManagerMock = mock(IConsoleManager.class);
        Task.resetInstanceCount();
    }

    @Test
    public void listTaskVideTest(){
        when(consoleManagerMock.readLine())
                .thenReturn("4")
                .thenReturn("exit");

        new TaskManager(consoleManagerMock).run();

        verify(consoleManagerMock, times(1)).writeLine("Aucune tâche à afficher");
    }

    @Test
    public void listTaskTest(){
        when(consoleManagerMock.readLine())
                .thenReturn("4")
                .thenReturn("exit");

        TaskList taskList = new TaskList();
        taskList.addTask(new Task("test 1"));
        taskList.addTask(new Task("test 2", true));

        new TaskManager(consoleManagerMock, taskList).run();

        verify(consoleManagerMock, times(1))
                .writeLine("1 | test 1 | En cours\n" +
                                 "2 | test 2 | Terminée\n");
    }

    @Test
    public void addTaskTest(){
        when(consoleManagerMock.readLine())
                .thenReturn("1")
                .thenReturn("")
                .thenReturn("test 1")
                .thenReturn("exit");

        new TaskManager(consoleManagerMock).run();

        verify(consoleManagerMock, times(1)).write("Entrez le commentaire de la tâche : ");
        verify(consoleManagerMock, times(1)).write("Veuillez entrer un commentaire non vide : ");
        verify(consoleManagerMock, times(1)).write("Tâche ajoutée !");
    }

    @Test
    public void deleteTaskTest(){
        when(consoleManagerMock.readLine())
                .thenReturn("3")
                .thenReturn("exit");

        when(consoleManagerMock.readLong())
                .thenReturn(2L)
                .thenReturn(1L);

        TaskList taskList = new TaskList();
        taskList.addTask(new Task("test 1"));

        new TaskManager(consoleManagerMock, taskList).run();

        verify(consoleManagerMock, times(1)).writeLine("1 | test 1 | En cours\n");
        verify(consoleManagerMock, times(1)).write("Tâche non trouvée, entrez un ID valide : ");
        verify(consoleManagerMock, times(1)).write("Tâche supprimée !");
    }

    @Test
    public void deleteTaskVideTest(){
        when(consoleManagerMock.readLine())
                .thenReturn("3")
                .thenReturn("exit");

        new TaskManager(consoleManagerMock).run();

        verify(consoleManagerMock, times(1)).writeLine("Aucune tâche à supprimer");
    }

    @Test
    public void terminerTacheTest(){
        when(consoleManagerMock.readLine())
                .thenReturn("2")
                .thenReturn("exit");

        when(consoleManagerMock.readLong())
                .thenReturn(2L)
                .thenReturn(1L);

        TaskList taskList = new TaskList();
        taskList.addTask(new Task("test 1"));

        new TaskManager(consoleManagerMock, taskList).run();

        verify(consoleManagerMock, times(1)).writeLine("1 | test 1 | En cours\n");
        verify(consoleManagerMock, times(1)).write("Tâche non trouvée, entrez un ID valide : ");
        verify(consoleManagerMock, times(1)).write("Tâche terminée !");
    }

    @Test
    public void terminerTacheVideTest(){
        when(consoleManagerMock.readLine())
                .thenReturn("2")
                .thenReturn("exit");

        TaskList taskList = new TaskList();
        taskList.addTask(new Task("test 1", true));

        new TaskManager(consoleManagerMock, taskList).run();

        verify(consoleManagerMock, times(1)).writeLine("Il n'y a aucune tâche à terminer");
    }
}
