package controller;

import models.Task;

import java.time.LocalTime;
import java.util.*;

public class TaskManager {
    protected ArrayList<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    protected boolean isOverlapping(Task task1, Task task2) {
        LocalTime task1Start = task1.getStartTime();
        LocalTime task1End = task1.isSingleTime() ? task1.getStartTime() : task1.getEndTime();

        LocalTime task2Start = task2.getStartTime();
        LocalTime task2End = task2.isSingleTime() ? task2.getStartTime() : task2.getEndTime();

        return (task2Start.isBefore(task1End) && task2End.isAfter(task1Start));

    }

    //Metodos para editar uma task

    public boolean editTask(int id, String name, String startTime, String endTime){
        int index = id - 1; // Retira 1 do ID para acessar o item da lista
        if((index >= 0) && (index <= tasks.size())){
            try{
                Task uptadedTask = new Task(name, startTime, endTime);

                for(int i = 0; i < tasks.size(); i++){
                    if(i != index && isOverlapping(tasks.get(i), uptadedTask)){
                        System.out.println(uptadedTask.getName() + " irá sobrepor tempo de uma outra tarefa: " + tasks.get(i));
                        return false;
                    }
                }

                tasks.set(index, uptadedTask);
                sortTasks();
                return true;
    
    
            }catch(IllegalArgumentException error){
                System.out.println(error.getMessage());
                return false;
            }
        } else{
            System.out.println("Tarefa com ID " + id + "não encontrada");
            return false;
        }
    }

    public boolean editTask(int id, String name, String startTime){
        int index = id - 1;
        if((index >= 0) && (index <= tasks.size())){
            try{
                // Task existingTask = tasks.get(index);
                Task uptadedTask = new Task(name, startTime);

                for(int i = 0; i < tasks.size(); i++){
                    if(i != index && isOverlapping(tasks.get(i), uptadedTask)){
                        System.out.println(uptadedTask.getName() + " irá sobrepor tempo de uma outra tarefa: " + tasks.get(i));
                        return false;
                    }
                }

                tasks.set(index, uptadedTask);
                sortTasks();
                return true;
    
    
            }catch(IllegalArgumentException error){
                System.out.println(error.getMessage());
                return false;
            }
        } else{
            System.out.println("Tarefa com ID " + id + "não encontrada");
            return false;
        }
    }

    // Metodos para cadastrar Tarefa
    public boolean addTask(String name, String startTime, String endTime) {
        try {
            Task newTask = new Task(name, startTime, endTime);

            for (Task task : tasks) {
                if (isOverlapping(task, newTask)) {
                    System.out.println(newTask.getName() + " irá sobrepor tempo de uma outra tarefa: " + task);
                    return false;
                }

            }

            tasks.add(newTask);
            sortTasks();
            return true;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    public boolean addTask(String name, String startTime) {
        try {
            Task newTask = new Task(name, startTime);

            for (Task task : tasks) {
                if (isOverlapping(task, newTask)) {
                    System.out.println(newTask.getName() + " irá sobrepor tempo de uma outra tarefa: " + task);
                    return false;
                }
            }

            tasks.add(newTask);
            sortTasks();
            return true;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    // Metodos para Remover Tarefas
    public boolean removeTask(int id) {
        int index = id - 1;
        if ((index) >= 0 && (index) < tasks.size()) {
            tasks.remove(index);
            return true;
        } else {
            return false;
        }

    }

    // Metodo para Imprimir lista atualizada
    public String getUptadedTasks() {
        if (tasks.isEmpty()) {
            return "Nenhuma tarefa inserida no dia ";
        } else {
            StringBuilder formatedTasks = new StringBuilder();
            int id = 1;
            for (Task task : tasks) {
                String line = id + ": " + task.getName() + " - " + task.getStartTime() +
                        (task.getEndTime() != null ? " - " + task.getEndTime() : "");
                formatedTasks.append(line + "\n");
                id++;
            }
            return formatedTasks.toString();
        }
    }

    protected void sortTasks() {
        tasks.sort(Comparator.comparing(Task::getStartTime));
    }
}
