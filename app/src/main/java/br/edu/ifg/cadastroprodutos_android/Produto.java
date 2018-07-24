package br.edu.ifg.cadastroprodutos_android;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

/**
 * Created by geovany.
 */
public class Produto implements Serializable{

    @Exclude
    private String key;

    @Exclude
    private long id;

    private String nome;
    private float valorUnitario;
    private int estoque;

    public Produto() {

    }

    public Produto(String key, String nome, float valorUnitario, int estoque) {
        this.key = key;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Exclude
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    @Exclude
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
