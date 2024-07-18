package views;

import javax.swing.JFrame;
// import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.User;

public class OptionsMenuScreen extends JFrame{
    public OptionsMenuScreen(User usuario){
        super("Bem vindo " + usuario);

        setResizable(false);
        setLayout(new BorderLayout());

        String[] opcoes = {"Inserir Tarefa", "Editar Tarefa","Remover Tarefa","Visualizar Tarefas","Sair"};


        JPanel panelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));

        for(String opcao: opcoes){
            JButton button = new JButton(opcao);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    dispose();
                    optionSelected(opcao);
                }
            });
            panelMenu.add(button);
        }

        add(panelMenu);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 350);


        
    }

    private void optionSelected(String opcao){
        switch (opcao){
            case "Inserir Tarefa":
                new InsertTask();
                break;
            case "Editar Tarefa":
                new EditTask();
                break;
            case "Remover Tarefa":
                new RemoveTask();
                break;
            case "Vizualizar Tarefas":
                new ViewTasks();
                break;
            case "Sair":
                dispose();
                break;
            default:
                System.out.println("Opçao errada");
        }
    }
}
