package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
// import controller.taskManager;
import controller.TaskManager;
import models.Task;

import java.awt.event.ActionListener;

public class RemoveTask extends JFrame{
    protected TaskManager taskManager;
    protected JTextArea textArea = new JTextArea();

    public RemoveTask(TaskManager taskManager){
        super("Remover Tarefas");

        this.taskManager = taskManager;

        setResizable(false);
        setLayout(new BorderLayout());

        
        
        JPanel panelRemove = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,20));

        JLabel removeLabel = new JLabel("Indice da Tarefa: ");
        JTextField removeField = new JTextField(5);

        JButton removeButton = new JButton("Remover");

        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(600,200));
         

        panelRemove.add(removeLabel);
        panelRemove.add(removeField);
        panelRemove.add(removeButton);
        panelRemove.add(new JScrollPane(textArea));

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String removeFieldString = removeField.getText();

                try{
                    int id = Integer.parseInt(removeFieldString);

                    boolean success = taskManager.removeTask(id);
                    
                    if(success){
                        JOptionPane.showMessageDialog(null,"Tarefa Removida com sucesso!");
                    } else{
                        JOptionPane.showMessageDialog(null, "Erro ao remover Tarefa, favor tentar novamente");
                    }
                    
                } catch(NumberFormatException error){
                    error.getMessage();
                }
                uptadedTasks();
            }
        });

       
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 350);

        add(panelRemove, BorderLayout.CENTER);

        uptadedTasks();
    }

    private void uptadedTasks(){
        textArea.setText("");
        if(taskManager.getTasks().isEmpty()){ 
            textArea.setText("Nenhuma tarefa inserida no dia");
        } else{
            int id = 1;
            for(Task task: taskManager.getTasks()){
                String line = id + ": " + task.getName() + " - " + task.getStartTime() +
                (task.getEndTime() != null ? " - " + task.getEndTime(): "");
                textArea.append(line + "\n");
                id++;
            }
        }
    }
    
}
