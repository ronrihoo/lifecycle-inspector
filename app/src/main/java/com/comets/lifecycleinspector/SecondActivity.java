package com.comets.lifecycleinspector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.comets.lifecycleinspector.Util.Config;
import com.comets.lifecycleinspector.database.DatabaseHandler;
import com.comets.lifecycleinspector.service.Listener;


public class SecondActivity extends AppCompatActivity {

    // Variable
    private String data;

    // DB
    public static DatabaseHandler entry;

    // Views
    public TextView textViewMain;
    public TextView textViewSecond;

    // Button
    Button backButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Context
        Config.secondActivityContext = this;

        // DB
        entry = new DatabaseHandler(this);

        // Views
        textViewMain = (TextView) findViewById(R.id.TextView_Main);
        textViewSecond = (TextView) findViewById(R.id.TextView_Second);

        // Button
        backButton = (Button) findViewById(R.id.Button_Back);

        // set an onClickListener for the buttons
        Listener.setup_Back_Button_Listener(backButton);

        // display the traces from MainActivity
        textViewMain.setText(entry.readFirst(0));

        // start writing to database to leave traces of the lifecycle
        entry.insert(entry.readFirst(1) + "\n" + "onCreate()", 1);
        entry.insert(entry.readFirst(0) + "\n", 0);

        data = entry.readFirst(1);

    }

    @Override
    protected void onStart() {
        super.onStart();
        entry.insert(entry.readFirst(1) + "\n" + "onStart()", 1);
        entry.insert(entry.readFirst(0) + "\n", 0);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }

    @Override
    protected void onResume() {
        super.onResume();
        entry.insert(entry.readFirst(1) + "\n" + "onResume()", 1);
        entry.insert(entry.readFirst(0) + "\n", 0);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }

    @Override
    protected void onPause() {
        super.onPause();
        entry.insert(entry.readFirst(1) + "\n" + "onPause()", 1);
        entry.insert(entry.readFirst(0) + "\n", 0);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }

    @Override
    protected void onStop() {
        super.onStop();
        entry.insert(entry.readFirst(1) + "\n" + "onStop()", 1);
        entry.insert(entry.readFirst(0) + "\n", 0);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        entry.insert(entry.readFirst(1) + "\n" + "onRestart()", 1);
        entry.insert(entry.readFirst(0) + "\n", 0);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        entry.insert(entry.readFirst(1) + "\n" + "onDestroy()", 1);
        entry.insert(entry.readFirst(0) + "\n", 0);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }

}
