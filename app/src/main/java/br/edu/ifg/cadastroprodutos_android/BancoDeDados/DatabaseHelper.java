package br.edu.ifg.cadastroprodutos_android.BancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by geovany
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final class PRODUTO{
        private static final String BANCO_DADOS = "Produtos";
        private static int VERSAO = 1;

        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String VALORUNITARIO = "valorUnitario";
        public static final String ESTOQUE = "estoque";

        public static final String TABLEDADOS = "produtos";
    }

    private static DatabaseHelper instance;

    public DatabaseHelper(Context context) {
        super(context, PRODUTO.BANCO_DADOS, null, PRODUTO.VERSAO);
    }

    public static DatabaseHelper getInstance(Context context){
        if(instance==null)
            instance = new DatabaseHelper(context);

        return instance;
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
