package br.edu.ifg.cadastroprodutos_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifg.cadastroprodutos_android.BancoDeDados.ProdutoDAOimpl;
import br.edu.ifg.cadastroprodutos_android.Produto;
import br.edu.ifg.cadastroprodutos_android.R;


public class ProdutoActivity extends AppCompatActivity {

    public static final String PRODUTO = "produto";
    private Intent i;

    private EditText nome;
    private EditText valorUnitario;
    private EditText estoque;

    private Produto produto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        i = getIntent();
        produto = (Produto) i.getSerializableExtra(ProdutoActivity.PRODUTO);

        nome = (EditText) findViewById(R.id.nome);
        valorUnitario = (EditText) findViewById(R.id.valorUnitario);
        estoque = (EditText) findViewById(R.id.estoque);

        if (produto != null) {
            nome.setText(produto.getNome());
            valorUnitario.setText(produto.getValorUnitario() + "");
            estoque.setText(produto.getEstoque() + "");
        }
    }

    public void salvar(View v){
        Produto novoProduto = new Produto();
        novoProduto.setNome(nome.getText().toString());

        if (valorUnitario.getText() != null) {
            novoProduto.setValorUnitario(Float.parseFloat(valorUnitario.getText().toString()));
        } else {
            novoProduto.setValorUnitario(0);
        }

        if (estoque.getText() != null) {
            novoProduto.setEstoque(Integer.parseInt(estoque.getText().toString()));
        } else {
            novoProduto.setEstoque(0);
        }

        ProdutoDAOimpl dao = new ProdutoDAOimpl();
        try {
            if (produto == null) {
                dao.inserir(novoProduto);
            } else {
                novoProduto.setId(produto.getId());
                dao.alterar(novoProduto);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Erro ao inserir o produto!", Toast.LENGTH_LONG).show();
        }

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}