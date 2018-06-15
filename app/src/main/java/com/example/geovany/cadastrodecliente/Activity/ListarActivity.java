package com.example.geovany.cadastrodecliente.Activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.geovany.cadastrodecliente.BancoDeDados.ProdutoDAOimpl;
import com.example.geovany.cadastrodecliente.Produto;
import com.example.geovany.cadastrodecliente.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListarActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        ProdutoDAOimpl dao = new ProdutoDAOimpl(this);
        try {
            List<Produto> p= dao.listarTodos();

            ArrayList<HashMap<String, String>> itens = new ArrayList<HashMap<String, String>>();
            for (Produto m : p) {
                HashMap<String, String> item = new HashMap<String, String>();

                item.put("Id", m.getId()+"");
                item.put("Nome", m.getNome());
                item.put("ValorUnitario", m.getValorUnitario() +"" );
                item.put("Estoque", m.getEstoque() + "");

                itens.add(item);
            }


            String[] from = new String[]{"Id", "Nome", "ValorUnitario", "Estoque"};


            int[] to = new int[]{R.id.textId, R.id.textNome, R.id.textValorUnitario, R.id.textEstoque};

            int resource = R.layout.activity_listar;

            SimpleAdapter adapter = new SimpleAdapter(this, itens, resource, from, to);

            setListAdapter(adapter);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage() + "Erro", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listar, menu);
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
