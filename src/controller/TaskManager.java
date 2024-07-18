package controller;

import models.Task;
import java.util.*;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public boolean insertTask(String name, String startTime){
        Task newTask = new Task(name, startTime);
        for(Task task : tasks){
            if(isOverlapping(task, newTask)){
                System.out.println("Ja existe uma tarefa nesse horario");
            }
        }

        tasks.add(newTask);
        tasks.sort(Comparator.comparing(Task::getStartTime));

        return true;


    }


    private boolean isOverlapping(Task task1, Task task2){
        return true;
    }
}
