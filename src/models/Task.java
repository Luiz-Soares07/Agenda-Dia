package models;

import java.time.*;
import java.time.format.*;

public class Task { 
    
    private String name;
    private LocalTime time;

    public Task(String name, String time){
        this.name = name;
        setTime(time);
        
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public LocalTime getTime(){
        return time;
    }

    public void setTime(Object time){
        try{    
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            this.time = LocalTime.parse((String) time, formatter);
        } catch(DateTimeParseException e){
            System.out.println("Hora Invalida: " + time);
            this.time = null;
        }


    }

    // public void setTIme(String time){
    //     this.time = time;
    // }

    @Override
    public String toString(){
        return "Task{name = '" + name + "', time = '" + time  + "'}";
    }


}
