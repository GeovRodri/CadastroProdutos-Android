package com.example.geovany.cadastrodecliente.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.geovany.cadastrodecliente.R;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void inserir(View v){
        Intent i = new Intent(this,InserirActivity.class);
        startActivity(i);
    }

    public void deletar(View v){
        /*Intent i = new Intent(this,);
        startActivity(i);*/
    }

    public void buscar(View v){
        /*Intent i = new Intent(this,);
        startActivity(i);*/
    }

    public void alterar(View v){
        /*Intent i = new Intent(this,);
        startActivity(i);*/
    }

    public void listar(View v){
        Intent i = new Intent(this,ListarActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
