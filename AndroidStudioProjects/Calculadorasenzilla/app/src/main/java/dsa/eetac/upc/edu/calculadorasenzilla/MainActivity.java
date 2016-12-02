package dsa.eetac.upc.edu.calculadorasenzilla;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


   StringBuilder historia= new StringBuilder();
    String tag="Events";
    private String getOperation(int value1, int value2, String operation, String result){
        StringBuilder sb= new StringBuilder();
        sb.append(value1);
        sb.append(operation);
        sb.append(value2);
        sb.append("=");
        sb.append(result);
        sb.append(",");
        return  sb.toString();
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        EditText editText1= (EditText) findViewById(R.id.editText1);
        EditText editText2= (EditText) findViewById(R.id.editText2);
        RadioGroup radioGroup= (RadioGroup)findViewById(R.id.rdgGrupo);
        TextView textBox= (TextView)findViewById(R.id.textView5);
        //Si el codigo se compara y el resutlado es OK
        if((requestCode==100)&&(resultCode== Activity.RESULT_OK)){
            //Coge los extras


            String[] fresult=null;
            Bundle resultsAct=data.getExtras();
            //De los extras coge el string identificado por "valor12"
            String[] stresult1= resultsAct.getString("selected").split("=");
            if(stresult1[0].contains("+")){
                fresult= stresult1[0].split("\\+");
                radioGroup.check(R.id.rdbOne1);

            }
            if(stresult1[0].contains("-")){
                fresult= stresult1[0].split("-");
                radioGroup.check(R.id.rdbTwo2);

            }
            if(stresult1[0].contains("*")){
                fresult= stresult1[0].split("\\*");
                radioGroup.check(R.id.rdbThree3);

            }
            if(stresult1[0].contains("/")){
                fresult= stresult1[0].split("/");
                radioGroup.check(R.id.rdbFour4);

            }
            editText1.setText(fresult[0].substring(4));
            editText2.setText(fresult[1]);
            textBox.setText("0");

        }
        else if(resultCode== 1337){
            this.historia.delete(0,historia.length());
        }

    }
    public void onClick3 (View v) {

//Operamos los valores en funcion del boton
        // Intent pasa de una vista a otra-----------------vista( hace falta cambiar el manifest)
        Intent intent = new Intent(getApplicationContext(), Historial.class);
        //Añade informacion extra el intent para pasarlo a la otra vista
        intent.putExtra("Op", historia.toString());
        //Inicia la activity esperando un resultado( nueva vista), codigo de actuacion(100)
        startActivityForResult(intent,100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
//Metodo cuando se hace click en el boton "Resultat"
    public void onClick1 (View v){

        //Valores de los campos EditText y de los RadioButton
        EditText editText1= (EditText) findViewById(R.id.editText1);
        EditText editText2= (EditText) findViewById(R.id.editText2);
        TextView textBox= (TextView)findViewById(R.id.textView5);
        RadioGroup radioGroup= (RadioGroup)findViewById(R.id.rdgGrupo);
        //Para convertir de int a string
        StringBuilder sb = new StringBuilder();
        int value1=0;
        int value2=0;
        Boolean correct=true;
        //Obtenemos id del boton seleccionado
        int radioButton = radioGroup.getCheckedRadioButtonId();

        try {
            //Comprovamos que tienen valores
            value1 = Integer.parseInt(editText1.getText().toString());
            value2 = Integer.parseInt(editText2.getText().toString());
            RadioButton radioButton1 = (RadioButton) findViewById(radioButton);
            String operation = radioButton1.getText().toString();
            if(operation.equals("+")){
                sb.append(value1+value2);
            }
            if(operation.equals("-")){
                sb.append(value1-value2);
            }
            if(operation.equals("*")){
                sb.append(value1*value2);
            }
            if(operation.equals("/")){
//Comprovamos si es divison entre zero
                if(value2==0) {sb.append("Infinity");
                }
                else
                {
                    //Comprovamos division entera o decimal
                    if(value1%value2!=0) {
                        correct=false;
                        Toast.makeText(getApplicationContext(), "Solo puedes hacer divisiones enteras",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        sb.append(value1 / value2);
                    }
                }
            }
            if(correct) {
                textBox.setText(sb.toString());
                historia.append(getOperation(value1,value2,operation.toString(),sb.toString()));

            }
            else{textBox.setText("INPUT ERROR");}
        }
        catch (Exception e)
        {
            //Si no tienen valores excepcion
            Toast.makeText(getApplicationContext(), "No puedes dejar uno de los dos valores en blanco",
                    Toast.LENGTH_LONG).show();
            textBox.setText("INPUT ERROR");

        }
    }

    public void onClick2(View v){
        //Valores de los campos EditTex y se pone a 0
        EditText editText1= (EditText) findViewById(R.id.editText1);
        EditText editText2= (EditText) findViewById(R.id.editText2);
        TextView textBox= (TextView)findViewById(R.id.textView5);
        editText1.setText("0");
        editText2.setText("0");
        textBox.setText("0");
    }

}
