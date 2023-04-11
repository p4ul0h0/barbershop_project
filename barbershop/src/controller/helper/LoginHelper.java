/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.helper;

import Model.Usuario;
import view.Login;

/**
 *
 * @author T-Gamer
 */
public class LoginHelper implements Helper{
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    @Override
    public Usuario getModel(){
        String name = view.getTxtuser().getText();
        String pass = view.getTxtpass().getText();
        
        Usuario model = new Usuario(0, name, pass);
        return model;
    }
    
    public void setModel(Usuario model){
        String name = model.getNome();
        String pass = model.getSenha();
        
        view.getTxtuser().setText(name);
        view.getTxtpass().setText(pass);
    }
    
    @Override
    public void clearScreen(){
        view.getTxtuser().setText("");
        view.getTxtpass().setText("");
    }
    
}
