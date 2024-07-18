package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.time.format.DateTimeFormatter;
// import java.util.concurrent.Flow;

public class MenuScreen extends JFrame{


    public MenuScreen(){
       
        super("Sistema de Gerenciamento de Tarefas"); //Titulo da Janela
        setResizable(false);
        // setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("<html>Bem vindo ao Sistema de Gerenciamento de tarefas do dia " +
            LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
            "<br/><br/>Por favor escolha entre uma das opções abaixo:</html>"); //Altera o formato da Data para "dd/mm/yyyy"
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(titleLabel, BorderLayout.NORTH);

        JPanel panelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        panelMenu.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton btnEntrar = new JButton("Entrar no Sistema");
        JButton btnSair = new JButton("Sair do Sistema");

        btnEntrar.setPreferredSize(new Dimension(150, 75));
        btnSair.setPreferredSize(new Dimension(150, 75));
        
        //Adiciona os botões ao componente panelMenu
        panelMenu.add(btnEntrar);
        panelMenu.add(btnSair);

        add(panelMenu, BorderLayout.CENTER);


        //Evento ao clicar no botão Entrar
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new UserNameScreen(); //Muda a tela para o campo de solicitação do nome de usuario
            }
        });

        //Evento para Sair do sistema
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 350);

        
    }

    
}
