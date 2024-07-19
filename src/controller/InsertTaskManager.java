package controller;


import models.Task;
import java.util.*;
import java.time.*;

public class InsertTaskManager {
    private ArrayList<Task> tasks;

    public InsertTaskManager(){
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public boolean addTask(String name, String startTime, String endTime){
        try{
            Task newTask = new Task(name, startTime, endTime);

            for(Task task: tasks){
                if(isOverlapping(task, newTask)){
                    System.out.println("Tarefa irá sobrepor tempo de uma outra tarefa: " + task);
                    return false;
                }

            }

            tasks.add(newTask);
            tasks.sort(Comparator. comparing(Task:: getStartTime));
            return true;

        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }   


    public boolean addTask(String name, String startTime){
        try{
            Task newTask = new Task(name, startTime);

            for(Task task: tasks){
                if(isOverlapping(task, newTask)){
                    System.out.println(newTask.getName() + " irá sobrepor tempo de uma outra tarefa: " + task);
                    return false;
                }
            }

            tasks.add(newTask);
            tasks.sort(Comparator.comparing(Task:: getStartTime));
            return true;

        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isOverlapping(Task task1,  Task task2){
        LocalTime task1Start = task1.getStartTime();
        LocalTime task1End = task1.isSingleTime() ? task1.getStartTime() : task1.getEndTime();

        LocalTime task2Start = task2.getStartTime();
        LocalTime task2End = task2.isSingleTime() ? task2.getStartTime() : task2.getEndTime();

        return (task2Start.isBefore(task1End) && task2End.isAfter(task1Start));


    }
}
