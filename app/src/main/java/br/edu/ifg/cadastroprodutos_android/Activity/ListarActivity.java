package br.edu.ifg.cadastroprodutos_android.Activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.ifg.cadastroprodutos_android.BancoDeDados.ProdutoDAOimpl;
import br.edu.ifg.cadastroprodutos_android.Produto;
import br.edu.ifg.cadastroprodutos_android.R;

public class ListarActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        ProdutoDAOimpl dao = new ProdutoDAOimpl(this);
        try {
            List<Produto> p = dao.listarTodos();

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
}
