import controller.InsertTaskManager;
// import views.MenuScreen;

public class Agenda{


    
    public static void main(String[] args) {
        InsertTaskManager newTask = new InsertTaskManager();

        newTask.addTask("Acordar","06:00");
        newTask.addTask("Academia","08:00", "10:00");
        newTask.addTask("Biblia", "09:00");

        System.out.println(newTask.getTasks());
        // new UserNameScreen();


       
    }
}