/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author T-Gamer
 */
public class Servico {
    private int Id;
    private String descricao;
    private float valor;

    public Servico(int Id, String descricao, float valor) {
        this.Id = Id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    @Override
    public String toString(){
        return getDescricao();
    }
    
}
