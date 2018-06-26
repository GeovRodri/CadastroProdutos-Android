package br.edu.ifg.cadastroprodutos_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.edu.ifg.cadastroprodutos_android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inserir(View v){
        Intent i = new Intent(this, ProdutoActivity.class);
        startActivity(i);
    }

    public void listar(View v){
        Intent i = new Intent(this, ListarProdutosActivity.class);
        startActivity(i);
    }
}
