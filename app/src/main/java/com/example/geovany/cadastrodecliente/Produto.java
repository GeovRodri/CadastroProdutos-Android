package com.example.geovany.cadastrodecliente;

import java.io.Serializable;

/**
 * Created by geovany on 22/04/15.
 */
public class Produto implements Serializable{

    private long id;
    private String nome;
    private float valorUnitario;
    private int estoque;

    public Produto() {

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
