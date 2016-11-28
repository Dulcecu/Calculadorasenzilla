package dsa.initial;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static dsa.initial.R.string.English;

/**
 * Created by Turpitude on 21/11/2016.
 */

public class SecondaryActivity extends AppCompatActivity {
    String tag="Events";
    int click=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);
        Log.d(tag,"event onCreate()");
        TextView textBox= (TextView)findViewById(R.id.textView1);
        textBox.setText(English);


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
