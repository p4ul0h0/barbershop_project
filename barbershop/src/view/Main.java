/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author T-Gamer
 */
public class Main {
    public static void main(String[] args) {
        
        Servico barba = new Servico(1, "barba", 30);
        
        System.out.println(barba.getDescricao());
        System.out.println(barba.getValor());
        
        Cliente cliente = new Cliente(1, "João Batista", "Rua tal la", "23131231");
        
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario(1, "barbaeiro", "1234");
                
        System.out.println(usuario.getNome());
        
        Agendamento agen = new Agendamento(1, cliente, barba, 30, "12/08/2022 13:45");
    
        System.out.println(agen.getCliente().getNome());
    }
}
