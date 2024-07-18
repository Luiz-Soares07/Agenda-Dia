package models;

import java.time.*;
// import java.time.format.*;

public class Task { 
    
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean singleTime;

    public Task(String name, String startTime, String endTime){
        this.name = name;
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
        this.singleTime = false;
    }

    public Task(String name, String startTime){
        this.name = name;
        this.startTime = LocalTime.parse(startTime);
        this.singleTime = true;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public LocalTime getStartTime(){
        return startTime;
    }

    public LocalTime getEndTime(){
        return endTime;
    }

    public boolean isSingleTime(){
        return singleTime;
    }
    @Override
    public String toString(){
        try{
            if(singleTime){
                if(startTime != null){
                    return name + " as " + startTime;
                } else{
                    throw new IllegalStateException("Hora de incio de forma Errada");
                }
                
            } else{
                if(startTime != null & endTime != null){
                    return name + " as " + startTime + " - " + endTime;
                } else{
                    throw new IllegalStateException("Hora de inicio e fim de forma errada");
                }
                
            }
        }catch(Exception e){
             return ("Aconteceu algum erro favor verificar");

        }
    }


}
