package com.netfanely.register;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/***
 *
 * @author fanely
 * @date 23-09-2019
 *
 * ****/
public class MainActivity extends AppCompatActivity {
    private EditText E1, E2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        E1 = (EditText) findViewById(R.id.editText);
        E2 = (EditText) findViewById(R.id.editText2);

    }
    //Registrar
    public void Ingresar(View view){
        AdminBD admin = new AdminBD(this, "BaseDatos",null,1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String usuario = E1.getText().toString();
        String pass = E2.getText().toString();


        if(usuario.length() == 0){

            Toast.makeText(this,"Ingrese Usuario Valido", Toast.LENGTH_LONG).show();

        }
        if(pass.length()==0) {
            Toast.makeText(this,"Por favor ingrese correctamente los campos",Toast.LENGTH_LONG).show();

        }
        if(usuario.length()!=0&&pass.length()!=0) {
            Toast.makeText(this,"Iniciando Sesion...",Toast.LENGTH_LONG).show();
        }
    }
}
