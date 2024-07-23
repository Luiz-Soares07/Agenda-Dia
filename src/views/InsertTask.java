package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.User;

// import controller.InsertTaskManager;
import controller.TaskManager;

public class InsertTask extends JFrame {
    protected TaskManager insertTask;
    protected User usuario;

    public InsertTask(User usuario, TaskManager taskManager) {
        super("Inserir Tarefa");

        this.insertTask = taskManager;
        this.usuario = usuario;

        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panelInsert = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));

        JLabel nameLabel = new JLabel("Nome da Tarefa: ");
        JTextField nameField = new JTextField(50);

        JLabel startTimeLabel = new JLabel("Horario de Ínicio: ");
        JTextField startTimeField = new JTextField(10);

        JLabel endTimeLabel = new JLabel("Horario de Fim: ");
        JTextField endTimeField = new JTextField(10);

        JButton addButton = new JButton("Adicionar Tarefa");
        JButton toGoBack = new JButton("Voltar");

        panelInsert.add(nameLabel);
        panelInsert.add(nameField);
        panelInsert.add(startTimeLabel);
        panelInsert.add(startTimeField);
        panelInsert.add(endTimeLabel);
        panelInsert.add(endTimeField);
        panelInsert.add(addButton);
        panelInsert.add(toGoBack);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String startTime = startTimeField.getText();
                String endTime = endTimeField.getText();

                boolean success;
                if (endTime.isEmpty()) {
                    success = insertTask.addTask(name, startTime);

                } else {
                    success = insertTask.addTask(name, startTime, endTime);
                }

                if (success) {
                    JOptionPane.showMessageDialog(null, "Tarefa Adicionada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar Tarefa, tente novamente");
                }

                nameField.setText("");
                startTimeField.setText("");
                endTimeField.setText("");
            }

        });

        toGoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new OptionsMenuScreen(usuario, taskManager);
            }
        });

        add(panelInsert, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 350);
    }

}
