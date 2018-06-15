package com.example.geovany.cadastrodecliente.BancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by geovany on 27/04/15.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final class PRODUTO{
        private static final String BANCO_DADOS = "Produtos";
        private static int VERSAO = 1;

        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String VALORUNITARIO = "valorUnitario";
        public static final String ESTOQUE = "estoque";

        public static final String TABLEDADOS = "produtos";
    }


    public DataBaseHelper(Context context) {
        super(context, PRODUTO.BANCO_DADOS, null, PRODUTO.VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + PRODUTO.TABLEDADOS +
                "(" + PRODUTO._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PRODUTO.NOME + " TEXT not null, " +
                PRODUTO.VALORUNITARIO + " REAL not null, " +
                PRODUTO.ESTOQUE + " INTEGER not null) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
