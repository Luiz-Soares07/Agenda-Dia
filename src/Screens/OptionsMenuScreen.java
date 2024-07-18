package Screens;

import javax.swing.JFrame;

import models.User;

public class OptionsMenuScreen extends JFrame{
    public OptionsMenuScreen(User usuario){
        super("Bem vindo " + usuario);

    }
}
