package controller;

import view.Agenda;
import view.MenuPrincipal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author T-Gamer
 */
public class MenuController {
    private final MenuPrincipal view;

    public MenuController(MenuPrincipal view) {
        this.view = view;
    }
    
    public void navigateToAppoBook(){
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
    }
    
}
