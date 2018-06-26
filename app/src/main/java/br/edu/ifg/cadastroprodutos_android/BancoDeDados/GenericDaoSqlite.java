package br.edu.ifg.cadastroprodutos_android.BancoDeDados;

import android.database.sqlite.SQLiteDatabase;
import br.edu.ifg.cadastroprodutos_android.util.MyApp;

public abstract class GenericDaoSqlite {

    public SQLiteDatabase getWritebleDB(){
        return DatabaseHelper.getInstance(MyApp.getContext()).getWritableDatabase();
    }


    public SQLiteDatabase getReadableDB(){
        return DatabaseHelper.getInstance(MyApp.getContext()).getReadableDatabase();
    }
}
