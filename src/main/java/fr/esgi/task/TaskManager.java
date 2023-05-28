package fr.esgi.task;

import java.util.List;

public class TaskManager {
    private TaskList taskList;
    private final IConsoleManager consoleManager;

    public TaskManager(IConsoleManager consoleManager){
        this.consoleManager = consoleManager;
        this.taskList = new TaskList();
    }

    public TaskManager(IConsoleManager consoleManager, TaskList taskList){
        this.consoleManager = consoleManager;
        this.taskList = taskList;
    }

    private void ajouterTache(){
        String commentaire = "";

        consoleManager.write("Entrez le commentaire de la tâche : ");
        while(commentaire.isEmpty()){
            commentaire = consoleManager.readLine();

            if(commentaire.isEmpty()){
                consoleManager.write("Veuillez entrer un commentaire non vide : ");
            }
        }

        taskList.addTask(new Task(commentaire));
        consoleManager.write("Tâche ajoutée !");
    }

    private void terminerTache(){
        List<Task> tasksNotDone = this.taskList.getNotDone();

        if(tasksNotDone.isEmpty()){
            consoleManager.writeLine("Il n'y a aucune tâche à terminer");
            return;
        }

        String formattedTasks = TaskList.formatToString(tasksNotDone);
        consoleManager.writeLine(formattedTasks);
        consoleManager.write("Entrez l'ID de la tâche à terminer : ");

        while(true){
            try {
                Long id = consoleManager.readLong();

                //On ne laisse passer que les taches non terminées
                if(taskList.getTask(id).isDone()){
                    throw new TaskNotFoundException();
                }

                taskList.markDone(id);
                break;
            }
            catch(TaskNotFoundException e){
                consoleManager.write("Tâche non trouvée, entrez un ID valide : ");
            }
        }

        consoleManager.write("Tâche terminée !");
    }

    private void supprimerTache(){
        if(taskList.getTasks().isEmpty()){
            consoleManager.writeLine("Aucune tâche à supprimer");
            return;
        }

        consoleManager.writeLine(taskList.toString());
        consoleManager.write("Entrez l'ID de la tâche à supprimer : ");

        while(true){
            try {
                Long id = consoleManager.readLong();
                taskList.deleteTask(id);
                break;
            }
            catch(TaskNotFoundException e){
                consoleManager.write("Tâche non trouvée, entrez un ID valide : ");
            }
        }

        consoleManager.write("Tâche supprimée !");
    }

    private void listerTaches(){
        if(taskList.getTasks().isEmpty()){
            consoleManager.writeLine("Aucune tâche à afficher");
            return;
        }

        consoleManager.writeLine(taskList.toString());
    }

    public void run(){
        String userInput = "";
        while(!"exit".equals(userInput)){
            consoleManager.writeLine("1 - Ajouter une tâche");
            consoleManager.writeLine("2 - Terminer une tâche");
            consoleManager.writeLine("3 - Supprimer une tâche");
            consoleManager.writeLine("4 - Lister les tâches");

            consoleManager.write("Faites votre choix : ");
            userInput = consoleManager.readLine();
            consoleManager.write("\n");

            switch(userInput){
                case "1" : ajouterTache(); break;
                case "2" : terminerTache(); break;
                case "3" : supprimerTache(); break;
                case "4" : listerTaches(); break;
            }

            consoleManager.write("\n");
        }
    }
}
