package br.edu.ifg.cadastroprodutos_android.Activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.cadastroprodutos_android.BancoDeDados.ProdutoDAOimpl;
import br.edu.ifg.cadastroprodutos_android.Produto;
import br.edu.ifg.cadastroprodutos_android.R;

import static br.edu.ifg.cadastroprodutos_android.Activity.InserirActivity.PRODUTO;

public class ListarActivity extends ListActivity {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        ProdutoDAOimpl dao = new ProdutoDAOimpl(this);
        try {
            produtos = dao.listarTodos();

            ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this,
                    android.R.layout.simple_list_item_1, produtos);

            setListAdapter(adapter);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage() + "Erro", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Produto produto = produtos.get(position);
        Intent i = new Intent(this, InserirActivity.class);
        i.putExtra(PRODUTO, produto);
        startActivity(i);
    }
}
