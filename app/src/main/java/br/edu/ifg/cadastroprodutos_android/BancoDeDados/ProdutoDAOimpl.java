package br.edu.ifg.cadastroprodutos_android.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.edu.ifg.cadastroprodutos_android.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geovany
 */
public class ProdutoDAOimpl extends GenericDaoSqlite implements ProdutoDAO{

    private Context context;

    public ProdutoDAOimpl(Context context){
        this.context = context;
    }

    @Override
    public Produto inserir(Produto p) throws Exception {
        SQLiteDatabase db = getWritebleDB();

        ContentValues values =  new ContentValues();

        values.put(DatabaseHelper.PRODUTO.NOME, p.getNome());
        values.put(DatabaseHelper.PRODUTO.VALORUNITARIO, p.getValorUnitario());
        values.put(DatabaseHelper.PRODUTO.ESTOQUE, p.getEstoque());

        long id = db.insert(DatabaseHelper.PRODUTO.TABLEDADOS,null,values);

        if(id == -1 )
            throw new Exception("Erro da gravação");

        p.setId(id);

        return p;
    }

    @Override
    public void excluir(Produto p) throws Exception {
        excluir(p.getId());
    } 

    @Override
    public void excluir(long id) throws Exception {
        SQLiteDatabase db = getWritebleDB();
        db.delete(DatabaseHelper.PRODUTO.TABLEDADOS, "_id=?", new String[]{DatabaseHelper.PRODUTO._ID});
    }

    @Override
    public List<Produto> listarTodos() throws Exception {
        SQLiteDatabase db = getWritebleDB();

        List<Produto> produtos = new ArrayList<>();
        Cursor res = db.rawQuery("SELECT * from " + DatabaseHelper.PRODUTO.TABLEDADOS, null);

        while(res.moveToNext()){
            Produto p = new Produto();

            p.setId(res.getInt(0));
            p.setNome(res.getString(1));
            p.setValorUnitario(res.getFloat(2));
            p.setEstoque(res.getInt(3));

            produtos.add(p);

        }

        res.close();
        return produtos;
    }

    @Override
    public Produto buscar(int id) throws Exception {
        SQLiteDatabase db = getReadableDB();

        Cursor res = db.rawQuery(DatabaseHelper.PRODUTO.TABLEDADOS,
                new String[]{DatabaseHelper.PRODUTO._ID, DatabaseHelper.PRODUTO.NOME, DatabaseHelper.PRODUTO.ESTOQUE,
                        DatabaseHelper.PRODUTO.VALORUNITARIO});
        
        if (res != null)
            res.moveToFirst();
        Produto p = new Produto();


        p.setId(res.getInt(0));
        p.setNome(res.getString(1));
        p.setValorUnitario(res.getFloat(2));
        p.setEstoque(res.getInt(3));

        return p;
    }

    @Override
    public boolean alterar(Produto p) throws Exception {
        SQLiteDatabase db = getWritebleDB();
        ContentValues atributos = new ContentValues();
        atributos.put("NOME", p.getNome());
        atributos.put("VALORUNITARIO", p.getValorUnitario());
        atributos.put("ESTOQUE", p.getEstoque());

        db.update(DatabaseHelper.PRODUTO.TABLEDADOS, atributos, "_id = ?", new String[]{p.getId() + ""});
        return true;
    }
}