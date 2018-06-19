package br.edu.ifg.cadastroprodutos_android;

import java.io.Serializable;

/**
 * Created by geovany.
 */
public class Produto implements Serializable{

    private long id;
    private String nome;
    private float valorUnitario;
    private int estoque;

    public Produto() {

    }

    @Override
    public String toString() {
        return nome;
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
