/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.DAO.UsuarioDAO;
import Model.Usuario;
import controller.helper.LoginHelper;
import view.Login;
import view.MenuPrincipal;

/**
 *
 * @author T-Gamer
 */
public class LoginController {

    private final Login view;
    private final LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void sysLogin(){
        Usuario user = helper.getModel();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(user);
        
        if(usuarioAutenticado != null){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        }else{
            view.exibeMenssagem("Usuario e/ou senha invalidos!");
            helper.clearScreen();
        }
    }
    
    public void fizTarefa(){
        System.out.println("busquei algo do db");
        
        this.view.exibeMenssagem("Executei o fiz tarefa");
    }
    
}
