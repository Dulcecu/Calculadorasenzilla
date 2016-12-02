package dsa.eetac.upc.edu.calculadorasenzilla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

/**
 * Created by Turpitude on 02/12/2016.
 */

public class Historial extends AppCompatActivity {

    String tag="Events";
    List<String> historial= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial);
        Log.d(tag, "event onCreate()");
        String[] totalop= getIntent().getExtras().getString("Op").split(",");
        for(int i=0;i<totalop.length;i++){
            if(!totalop[i].equals("")) {
                historial.add(i + 1 + " : " + totalop[i]);
            }
        }

        ArrayAdapter adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,historial);
        ListView listView=(ListView)findViewById(R.id.List);
        listView.setAdapter(adapter);

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Intent intres = getIntent();
        if((requestCode==101)&&(resultCode== Activity.RESULT_OK)) {
            this.historial.clear();
            setResult(1337, intres);
            finish();
        }
    }

    public void onClick2 (View v) {
        Intent intent = new Intent(getApplicationContext(), Eliminar.class);
        //Añade informacion extra el intent para pasarlo a la otra vista
        //Inicia la activity esperando un resultado( nueva vista), codigo de actuacion(100)
        startActivityForResult(intent,101);

    }


    public void onClick1 (View v) {


        Intent intres = getIntent();
        EditText editText= (EditText) findViewById(R.id.editText3);
        String selected = editText.getText().toString();
        try {

            int i = Integer.parseInt(selected);
            //Este utiliza el intent de antes
            //Añade valores al valor identificado como "valor12"
            intres.putExtra("selected", historial.get(i - 1).toString());
            //Establece el resultado como OK
            setResult(RESULT_OK, intres);
            finish();

        }
        catch (Exception e){

            setResult(RESULT_CANCELED, intres);
            if(historial.size()==0) {
                Toast.makeText(getApplicationContext(), "Historial vacio",
                        Toast.LENGTH_LONG).show();
                finish();
            }
            else {
                if (editText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Ningun valor elegido",
                            Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Fuera del margen del historial",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
        //Acaba el intent y lo ejecuta

    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(tag,"event onStart()");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(tag,"event onResume()");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(tag,"event onPause()");
    }
    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(tag,"event onRestart()");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(tag,"event onStop()");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(tag,"event onDestroy()");
    }
}
