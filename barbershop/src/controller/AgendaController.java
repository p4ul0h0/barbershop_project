/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import controller.helper.AgendaHelper;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.Agenda;

/**
 *
 * @author T-Gamer
 */
public class AgendaController {
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        helper = new AgendaHelper(view);
    }
    
    public void updateTable(){
        AgendamentoDAO agenDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agenDAO.selectAll();
        
        helper.insertInTable(agendamentos);
    }
    
    public void updateClients(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
    
        helper.insertClientsInBox(clientes);
    }
    
    public void updateServices(){
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.insertServicesInBox(servicos);
    }
    
    public void updatePrice(){
        Servico servico = helper.getService();
        helper.setPrice(servico.getValor());
    }
   
    public void setTxtIdToLast(){
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        helper.getLastId(agendamentos);
    }
    
    public void schedule(){
        try{
        Agendamento agendamento = helper.getModel();
        new AgendamentoDAO().insert(agendamento);
        JOptionPane.showMessageDialog(null, "Agendado com sucesso!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        updateTable();
        helper.clearScreen();
        setTxtIdToLast();
    }
    
}
