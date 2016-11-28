package dsa.eetac.upc.edu.calculadorasenzilla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    String tag="Events";

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
                        sb.append("0");
                        Toast.makeText(getApplicationContext(), "Solo puedes hacer divisiones enteras",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        sb.append(value1 / value2);
                    }
                }
            }
            textBox.setText(sb.toString());
        }
        catch (Exception e)
        {
            //Si no tienen valores excepcion
            Toast.makeText(getApplicationContext(), "No puedes dejar uno de los dos valores en blanco",
                    Toast.LENGTH_LONG).show();

        }
        //Operamos los valores en funcion del boton


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
