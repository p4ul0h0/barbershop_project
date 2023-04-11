/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import view.Agenda;

/**
 *
 * @author T-Gamer
 */
public class AgendaHelper implements Helper{
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void insertInTable(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) this.view.getDataTable().getModel();
        tableModel.setNumRows(0);
        
        for(Agendamento agendamento: agendamentos){
            
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getFormatedDate(),
                agendamento.getFormatedTime(),
                agendamento.getObservacao()
            });
            
        }
        
        this.view.getDataTable().setModel(tableModel);
        
    }

    public void insertClientsInBox(ArrayList<Cliente> clientes) {
        DefaultComboBoxModel boxModel = (DefaultComboBoxModel) this.view.getTxtcliente().getModel();
        for(Cliente cliente: clientes){
            boxModel.addElement(cliente);
        }
    }

    public void insertServicesInBox(ArrayList<Servico> servicos) {
       DefaultComboBoxModel boxModel = (DefaultComboBoxModel) this.view.getTxtservico().getModel();
       for(Servico servico: servicos){
           boxModel.addElement(servico);
       }
    }
    
    public Cliente getClient(){
        return (Cliente) this.view.getTxtcliente().getSelectedItem();
    }
    
    public void getLastId(ArrayList<Agendamento> agendamentos){
        Agendamento ultimoAgendamento = agendamentos.get(agendamentos.size() - 1);
        this.view.getTxtid().setText(String.valueOf(ultimoAgendamento.getId()+1));
    }

    public Servico getService() {
       return (Servico) this.view.getTxtservico().getSelectedItem();
    }

    public void setPrice(float valor) {
        this.view.getTxtvalor().setText(String.valueOf(valor));
    }

    @Override
    public Agendamento getModel() {
        int id = Integer.parseInt(this.view.getTxtid().getText());
        Cliente cliente = getClient();
        Servico servico = getService();
        float price = Float.parseFloat(this.view.getTxtvalor().getText());
        String data = this.view.getTxtdata().getText();
        String hora = this.view.getTxthora().getText();
        String dataHora = data + " " + hora;
        String observacao = this.view.getTxtobs().getText();
        Agendamento agendamento = new Agendamento(id, cliente, servico, price, dataHora, observacao);
        return agendamento;
    }

    @Override
    public void clearScreen() {
        this.view.getTxtdata().setText("");
        this.view.getTxthora().setText("");
        this.view.getTxtobs().setText("");
    }

    
}
