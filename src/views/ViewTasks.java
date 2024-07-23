package views;

import javax.swing.*;

import controller.TaskManager;
// import models.Task;
import models.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTasks extends JFrame {
    protected TaskManager taskManager;
    protected User usuario;
    protected JTextArea textArea = new JTextArea();

    public ViewTasks(User usuario, TaskManager taskManager) {
        super("Visualizar Tarefas");

        this.usuario = usuario;
        this.taskManager = taskManager;

        setResizable(false);
        setLayout(new BorderLayout());

        JPanel viewPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        JLabel tittleLabel = new JLabel("Sua lista de tarefas de Hoje " + usuario.getName() + ": ");

        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(600, 200));

        JButton toGoBack = new JButton("Voltar");

        viewPanel.add(tittleLabel);
        viewPanel.add(new JScrollPane(textArea));
        viewPanel.add(toGoBack);

        toGoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new OptionsMenuScreen(usuario, taskManager);
            }
        });

        add(viewPanel, BorderLayout.CENTER);

        listTasks();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 350);

    }

    private void listTasks() {
        textArea.setText("");
        textArea.setText(taskManager.getUptadedTasks());
    }
}
