package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import controller.TaskManager;
import models.User;

import java.awt.event.ActionListener;

public class RemoveTask extends JFrame {
    protected TaskManager taskManager;
    protected User usuario;
    protected JTextArea textArea = new JTextArea();

    public RemoveTask(User usuario, TaskManager taskManager) {
        super("Remover Tarefas");

        this.taskManager = taskManager;
        this.usuario = usuario;

        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panelRemove = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));

        JLabel removeLabel = new JLabel("Indice da Tarefa: ");
        JTextField removeField = new JTextField(5);

        JButton removeButton = new JButton("Remover");

        JButton toGoBack = new JButton("Voltar");

        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(600, 200));

        panelRemove.add(removeLabel);
        panelRemove.add(removeField);
        panelRemove.add(removeButton);
        panelRemove.add(toGoBack);
        panelRemove.add(new JScrollPane(textArea));

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String removeFieldString = removeField.getText();

                try {
                    int id = Integer.parseInt(removeFieldString);

                    boolean success = taskManager.removeTask(id);

                    if (success) {
                        JOptionPane.showMessageDialog(null, "Tarefa Removida com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao remover Tarefa, favor tentar novamente");
                    }

                } catch (NumberFormatException error) {
                    error.getMessage();
                }
                uptadedTasks();
            }
        });

        toGoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new OptionsMenuScreen(usuario, taskManager);
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 350);

        add(panelRemove, BorderLayout.CENTER);

        uptadedTasks();
    }

    private void uptadedTasks() {
        textArea.setText("");
        textArea.setText(taskManager.getUptadedTasks());
    }

}
