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
public class RegistroActivity extends AppCompatActivity {
    private EditText E_DNI, E_Nombre, E_telf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        E_DNI = (EditText) findViewById(R.id.editText3);
        E_Nombre = (EditText) findViewById(R.id.editText4);
        E_telf = (EditText) findViewById(R.id.editText5);
    }
    //Registrar
    public void Registrar(View view){
        AdminBD admin = new AdminBD(this, "BaseDatos",null,1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String DNI = E_DNI.getText().toString();
        String Nombre = E_Nombre.getText().toString();
        String Telf = E_telf.getText().toString();

        if(!DNI.isEmpty()&&!Nombre.isEmpty() && !Telf.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("DNI",DNI);
            registro.put("Nombre", Nombre);
            registro.put("Telf", Telf);
            BaseDatos.insert("usuario",null,registro);

            BaseDatos.close();
            E_DNI.setText("");
            E_Nombre.setText("");
            E_telf.setText("");
            Toast.makeText(this,"Almacenando Datos", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"Por favor ingrese correctamente los campos",Toast.LENGTH_LONG).show();

        }
    }
}
