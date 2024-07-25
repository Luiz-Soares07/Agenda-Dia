package views;


import javax.swing.*;

import controller.TaskManager;
import models.User;

import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class EditTask extends JFrame {
    protected TaskManager taskManager;
    protected User usuario;
    protected JTextArea textArea = new JTextArea();
    protected CardLayout cardLayout;
    protected JPanel cardPanel; 

    public EditTask(User usuario, TaskManager taskManager) {
        super("Editar Tarefas");

        this.taskManager = taskManager;
        this.usuario = usuario;

        setResizable(false);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel editPanelSelected = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));

        JLabel idLabel = new JLabel("ID: ");
        JTextField idField = new JTextField(5);

        JButton idButton = new JButton("Avançar");

        JButton toGoBack = new JButton("Voltar");

        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(600, 200));

        toGoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new OptionsMenuScreen(usuario, taskManager);
            }
        });

        editPanelSelected.add(idLabel);
        editPanelSelected.add(idField);
        editPanelSelected.add(idButton);
        editPanelSelected.add(new JScrollPane(textArea));
        editPanelSelected.add(toGoBack);

        cardPanel.add(editPanelSelected, "SelectPanel");

        

        idButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = idField.getText();

                try {
                    Integer id = Integer.parseInt(idString);
               

                    showEditableTaks(id);
                    cardLayout.show(cardPanel, "EditPanel");


                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, error);

                }

            }
        });

        add(cardPanel);

        uptatedTaks();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 350);
    }

    private void uptatedTaks() {
        textArea.setText("");
        textArea.setText(taskManager.getUptadedTasks());

    }

    protected void showEditableTaks(int id) {
        

        JPanel editPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));

        JLabel name = new JLabel("Tarefa:");
        JTextField nameField = new JTextField(20);

        JLabel startTimeLabel = new JLabel("Hora de Ínicio:");
        JTextField startTimeField = new JTextField(5);

        JLabel endTimeLabel = new JLabel("Hora do Fim:");
        JTextField endTimeField = new JTextField(5);

        JButton editButton = new JButton("Editar");
        JButton cancelButton = new JButton("Cancelar");

        editPanel.add(name);
        editPanel.add(nameField);
        editPanel.add(startTimeLabel);
        editPanel.add(startTimeField);
        editPanel.add(endTimeLabel);
        editPanel.add(endTimeField);
        editPanel.add(editButton);
        editPanel.add(cancelButton);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nameString = nameField.getText();
                String startTime = startTimeField.getText();
                String endTime = endTimeField.getText();

                boolean success;

                if(endTime.isEmpty()){
                    success = taskManager.editTask(id, nameString, startTime);
                } else{
                    success = taskManager.editTask(id,nameString, startTime, endTime);
                }

                if (success){
                    uptatedTaks();
                    JOptionPane.showMessageDialog(null, "Tarefa Editada com sucesso");
                    cardLayout.show(cardPanel, "SelectPanel");  
                } else{
                    JOptionPane.showMessageDialog(null, "Erro ao editar tarefa!");
                }

                revalidate();
                repaint();
            }


            
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "SelectPanel");
            }
        });

        cardPanel.add(editPanel, "EditPanel");
        cardLayout.show(cardPanel, "EditPanel");



        
    }


}
