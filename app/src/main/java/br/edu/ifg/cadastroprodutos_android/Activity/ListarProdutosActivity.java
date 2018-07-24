package br.edu.ifg.cadastroprodutos_android.Activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifg.cadastroprodutos_android.BancoDeDados.ProdutoDAO;
import br.edu.ifg.cadastroprodutos_android.Produto;
import br.edu.ifg.cadastroprodutos_android.R;
import br.edu.ifg.cadastroprodutos_android.util.MyApp;

import static br.edu.ifg.cadastroprodutos_android.Activity.ProdutoActivity.PRODUTO;

public class ListarProdutosActivity extends ListActivity {

    private List<Produto> produtos = new ArrayList<>();
    ArrayAdapter<Produto> adapter = null;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        try {
            produtos = new ArrayList<>();

            adapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos);
            setListAdapter(adapter);
            addObsersable();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage() + "Erro", Toast.LENGTH_LONG).show();
        }
    }

    private void addObsersable() {
        mDatabase.child("produtos").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> hashProdutos = (HashMap<String,Object>) dataSnapshot.getValue();

                produtos = new ArrayList<>();
                for (String key : hashProdutos.keySet()) {
                    Map<String, Object> map = (Map<String, Object>) hashProdutos.get(key);

                    String nome = map.get("nome") != null ? (String) map.get("nome") : null;
                    Float valorUnitario = map.get("valorUnitario") != null ? Float.valueOf(map.get("valorUnitario").toString()) : null;
                    Integer estoque = map.get("estoque") != null ? Integer.valueOf(map.get("estoque").toString()) : null;

                    produtos.add(new Produto(key, nome, valorUnitario, estoque));
                }

                adapter.clear();
                adapter.addAll(produtos);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MyApp.getContext(), "Erro: observer cancelado", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Produto produto = produtos.get(position);
        Intent i = new Intent(this, ProdutoActivity.class);
        i.putExtra(PRODUTO, produto);
        startActivity(i);
    }
}
