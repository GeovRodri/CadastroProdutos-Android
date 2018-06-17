package br.edu.ifg.cadastroprodutos_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import br.edu.ifg.cadastroprodutos_android.Produto;
import br.edu.ifg.cadastroprodutos_android.R;


public class InserirActivity extends AppCompatActivity {

    public static final String PRODUTO = "produto";

    private EditText nome;
    private EditText valorUnitario;
    private EditText estoque;

    private Produto produto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        nome = (EditText) findViewById(R.id.nome);
        valorUnitario = (EditText) findViewById(R.id.valorUnitario);
        estoque = (EditText) findViewById(R.id.estoque);
    }

    public void salvar(View v){
        produto = new Produto();

        produto.setNome(nome.getText().toString());

        if (valorUnitario.getText() != null) {
            produto.setValorUnitario(Float.parseFloat(valorUnitario.getText().toString()));
        }

        if (estoque.getText() != null) {
            produto.setEstoque(Integer.parseInt(estoque.getText().toString()));
        }

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(PRODUTO, produto);

        startActivity(i);

    }
}