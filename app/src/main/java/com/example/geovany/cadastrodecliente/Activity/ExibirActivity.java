package com.example.geovany.cadastrodecliente.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geovany.cadastrodecliente.BancoDeDados.ProdutoDAOimpl;
import com.example.geovany.cadastrodecliente.Produto;
import com.example.geovany.cadastrodecliente.R;


public class ExibirActivity extends ActionBarActivity {

    private Intent i;
    private Produto produto;

    private TextView nome;
    private TextView valorUnitario;
    private TextView estoque;

    private ProdutoDAOimpl db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);
        db = new ProdutoDAOimpl(this);

        i = getIntent();

        produto = (Produto) i.getSerializableExtra(InserirActivity.PRODUTO);
        nome = (TextView) findViewById(R.id.nome);
        valorUnitario = (TextView) findViewById(R.id.valorUnitario);
        estoque = (TextView) findViewById(R.id.estoque);

        try {
            produto = db.inserir(produto);

            nome.setText(produto.getNome());
            valorUnitario.setText(produto.getValorUnitario() + "");
            estoque.setText(produto.getEstoque() + "");

            Toast.makeText(this, "Salvado com sucesso", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage() + "Erro", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
