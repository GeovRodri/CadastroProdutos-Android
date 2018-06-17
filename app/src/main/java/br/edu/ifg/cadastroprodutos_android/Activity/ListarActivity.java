package br.edu.ifg.cadastroprodutos_android.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.ifg.cadastroprodutos_android.BancoDeDados.ProdutoDAOimpl;
import br.edu.ifg.cadastroprodutos_android.Produto;
import br.edu.ifg.cadastroprodutos_android.R;

public class ListarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        ListView listaDeProdutos = (ListView) findViewById(R.id.lista);

        ProdutoDAOimpl dao = new ProdutoDAOimpl(this);
        try {
            List<Produto> produtos = dao.listarTodos();

            ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this,
                    android.R.layout.simple_list_item_1, produtos);

            listaDeProdutos.setAdapter(adapter);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage() + "Erro", Toast.LENGTH_LONG).show();
        }
    }
}
