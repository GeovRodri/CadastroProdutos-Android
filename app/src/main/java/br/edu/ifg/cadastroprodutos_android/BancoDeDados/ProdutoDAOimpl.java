package br.edu.ifg.cadastroprodutos_android.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.edu.ifg.cadastroprodutos_android.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geovany on 01/05/15.
 */
public class ProdutoDAOimpl implements ProdutoDAO{

    private DataBaseHelper helper;
    private Context context;

    public ProdutoDAOimpl(Context context){
        this.context = context;
        helper = new DataBaseHelper(context);
    }

    @Override
    public Produto inserir(Produto p) throws Exception {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values =  new ContentValues();

        values.put(DataBaseHelper.PRODUTO.NOME, p.getNome());
        values.put(DataBaseHelper.PRODUTO.VALORUNITARIO, p.getValorUnitario());
        values.put(DataBaseHelper.PRODUTO.ESTOQUE, p.getEstoque());

        long id = db.insert(DataBaseHelper.PRODUTO.TABLEDADOS,null,values);

        if(id == -1 )
            throw new Exception("Erro da gravação");

        p.setId(id);

        return p;
    }

    @Override
    public void excluir(Produto p) throws Exception {
        excluir(p.getId());
        System.out.println("Removendo o produto: " + p.getId());
        excluir(p.getId());
    } 

    @Override
    public void excluir(long id) throws Exception {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(DataBaseHelper.PRODUTO.TABLEDADOS, "_id=?", new String[]{DataBaseHelper.PRODUTO._ID});
           

    }

    @Override
    public List<Produto> listarTodos() throws Exception {
        List<Produto> produtos = new ArrayList<>();

        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from " + DataBaseHelper.PRODUTO.TABLEDADOS, null);

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
        SQLiteDatabase db = helper.getWritableDatabase();


        Cursor res = db.rawQuery(DataBaseHelper.PRODUTO.TABLEDADOS,
                new String[]{DataBaseHelper.PRODUTO._ID, DataBaseHelper.PRODUTO.NOME, DataBaseHelper.PRODUTO.ESTOQUE,
                        DataBaseHelper.PRODUTO.VALORUNITARIO});
        
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
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues atributos = new ContentValues();
        atributos.put("_ID",DataBaseHelper.PRODUTO._ID);
        atributos.put("NOME",DataBaseHelper.PRODUTO.NOME);
        atributos.put("VALORUNITARIO",DataBaseHelper.PRODUTO.VALORUNITARIO);
        atributos.put("ESTOQUE",DataBaseHelper.PRODUTO.ESTOQUE);

        db.update(DataBaseHelper.PRODUTO.TABLEDADOS, atributos, "_id = ?", new String[]{DataBaseHelper.PRODUTO._ID});
        return true;
    }
}