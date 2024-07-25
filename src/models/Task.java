package models;

import java.time.*;


public class Task {

    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean singleTime;

    // Um Construtor para caso tenha um horario de inicio e um horario de fim.
    public Task(String name, String startTime, String endTime) {
        this.name = name;
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
        this.singleTime = false;
    }

    // Um Construtor para caso que tenha somente horario de inicio.
    public Task(String name, String startTime) {
        this.name = name;
        this.startTime = LocalTime.parse(startTime);
        this.singleTime = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isSingleTime() {
        return singleTime;
    }

    @Override
    public String toString() {
        try {
            if (singleTime) { // Realiza as verificações para caso a hora de incio esteja em formato errado
                if (startTime != null) {
                    return name + " as " + startTime;
                } else {
                    throw new IllegalStateException("Hora de incio de forma Errada");
                }

            } else { // Realiza as verificações para caso as horas de incio e fim estejam em formato
                     // errado
                if (startTime != null & endTime != null) {
                    return name + " as " + startTime + " - " + endTime;
                } else {
                    throw new IllegalStateException("Hora de inicio e fim de forma errada");
                }

            }
        } catch (Exception e) {
            return ("Aconteceu algum erro favor verificar");

        }
    }

}
