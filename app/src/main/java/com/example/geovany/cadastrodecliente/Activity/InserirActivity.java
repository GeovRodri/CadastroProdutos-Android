package com.example.geovany.cadastrodecliente.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.geovany.cadastrodecliente.Activity.ExibirActivity;
import com.example.geovany.cadastrodecliente.Produto;
import com.example.geovany.cadastrodecliente.R;


public class InserirActivity extends ActionBarActivity {

    public static final String PRODUTO = "produto";

    private EditText nome;
    private EditText valorUnitario;
    private EditText estoque;

    private Produto produto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.nome);
        valorUnitario = (EditText) findViewById(R.id.valorUnitario);
        estoque = (EditText) findViewById(R.id.estoque);
    }

    public void enviar(View v){
        produto = new Produto();

        produto.setNome(nome.getText().toString());
        produto.setValorUnitario(Float.parseFloat(valorUnitario.getText().toString()));
        produto.setEstoque(Integer.parseInt(estoque.getText().toString()));

        Intent i = new Intent(this, ExibirActivity.class);
        i.putExtra(PRODUTO, produto);

        startActivity(i);

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
