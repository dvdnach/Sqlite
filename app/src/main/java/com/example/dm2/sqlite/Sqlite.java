package com.example.dm2.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Sqlite extends AppCompatActivity {

    private Contacto[] datos = new Contacto[]{
            new Contacto("david","nacher","123456789")
    };
    private ListView lista;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        Sqlitehelper usdbh = new Sqlitehelper(this,"DBContactos",null,1);

        AdaptadorContactos adaptador = new AdaptadorContactos(this,datos);
        lista = (ListView)findViewById(R.id.list);
        lista.setAdapter(adaptador);
    }

    public void insertar ()
    {

    }

    public void actualizar ()
    {

    }

    public void eliminar ()
    {

    }

    public void consultar ()
    {

    }

    public class Sqlitehelper extends SQLiteOpenHelper
    {
        private String sqlCreate = "CREATE TABLE Contactos (idContacto INTEGER PRIMARY KEY, nombre TEXT, apellidos TEXT, numero INTEGER )";
        public Sqlitehelper (Context context, String nombre, SQLiteDatabase.CursorFactory factory,int version)
        {
            super(context,nombre,factory,version);
        }
        public void onCreate (SQLiteDatabase db)
        {
            db.execSQL(sqlCreate);
        }
        public void onUpgrade(SQLiteDatabase db, int i, int i1)
        {
            db.execSQL("DROP TABLE IF EXISTS Contactos");
            db.execSQL(sqlCreate);
        }
    }

    public class Contacto
    {
        private String nombre;
        private String apellidos;
        private String numero;

        public Contacto(String nombre, String apellidos, String numero) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.numero = numero;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public String getNumero() {
            return numero;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }
    }
    public class AdaptadorContactos extends ArrayAdapter<Contacto>
    {
        public AdaptadorContactos(Context context, Contacto[] datos) {
            super(context,R.layout.lista,datos);
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.lista,null);

            TextView lbl1= (TextView) item.findViewById(R.id.lbl1);
            TextView lbl2= (TextView) item.findViewById(R.id.lbl2);

            lbl1.setText(datos[position].getNombre()+" "+datos[position].getApellidos());
            lbl2.setText(datos[position].getNumero());

            return item;
        }
    }
}
