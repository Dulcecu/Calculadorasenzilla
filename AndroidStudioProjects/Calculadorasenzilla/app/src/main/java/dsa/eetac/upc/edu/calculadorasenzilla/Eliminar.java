package dsa.eetac.upc.edu.calculadorasenzilla;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by Turpitude on 02/12/2016.
 */

public class Eliminar extends AppCompatActivity {
    String tag="Events";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminar);
        Log.d(tag, "event onCreate()");
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
    public void onClick1 (View v) {

        Intent intres = getIntent();
        setResult(RESULT_OK, intres);
        finish();

    } public void onClick2 (View v) {

        Intent intres = getIntent();
        setResult(RESULT_CANCELED, intres);
        finish();

    }
}
