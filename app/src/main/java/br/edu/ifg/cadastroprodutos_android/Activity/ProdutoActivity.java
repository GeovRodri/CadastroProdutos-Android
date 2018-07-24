package br.edu.ifg.cadastroprodutos_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.edu.ifg.cadastroprodutos_android.Produto;
import br.edu.ifg.cadastroprodutos_android.R;


public class ProdutoActivity extends AppCompatActivity {

    public static final String PRODUTO = "produto";
    private Intent i;

    private EditText nome;
    private EditText valorUnitario;
    private EditText estoque;
    private Button buttonExcluir;

    private Produto produto;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        buttonExcluir = (Button)findViewById(R.id.buttonExcluir);

        i = getIntent();
        produto = (Produto) i.getSerializableExtra(ProdutoActivity.PRODUTO);

        nome = (EditText) findViewById(R.id.nome);
        valorUnitario = (EditText) findViewById(R.id.valorUnitario);
        estoque = (EditText) findViewById(R.id.estoque);

        if (produto != null) {
            nome.setText(produto.getNome());
            valorUnitario.setText(produto.getValorUnitario() + "");
            estoque.setText(produto.getEstoque() + "");

            buttonExcluir.setVisibility(View.VISIBLE);
        }
    }

    public void excluir(View v) {
        mDatabase.child("produtos").child(produto.getKey()).removeValue();

        Toast.makeText(this, "Produto excluido com sucesso!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
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


        try {
            if (produto == null) {
                mDatabase.child("produtos").push().setValue(novoProduto);
            } else {
                mDatabase.child("produtos").child(produto.getKey()).setValue(novoProduto);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Erro ao inserir o produto!", Toast.LENGTH_LONG).show();
        }

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}