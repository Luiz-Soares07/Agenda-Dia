package Screens;

import models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserNameScreen extends JFrame{
    public UserNameScreen(){
        super("Digite o seu nome");
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Informe o seu nome: ");
        JTextField inputName = new JTextField(20);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JButton btnPronto = new JButton("Pronto");

        btnPronto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name = inputName.getText();
                dispose(); //Fecha a tela atual

                User usuario = new User(name);
                new OptionsMenuScreen(usuario);
            }

        });

        panel.add(label);
        panel.add(inputName);
        panel.add(btnPronto);

        add(panel, BorderLayout.CENTER);

        
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 350);


       

    }
    
    
}
