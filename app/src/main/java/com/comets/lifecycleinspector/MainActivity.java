package com.comets.lifecycleinspector;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.comets.lifecycleinspector.Util.Config;
import com.comets.lifecycleinspector.database.DatabaseHandler;
import com.comets.lifecycleinspector.service.Listener;


public class MainActivity extends AppCompatActivity {

    // Variable
    private String data;

    // DB
    public static DatabaseHandler entry;

    // View
    public TextView textViewMain;
    public TextView textViewSecond;

    // Buttons
    private Button crashButton;
    private Button clearButton;
    private Button intentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Context
        Config.context = this;      // enable the use of this context in other places

        // DB
        entry = new DatabaseHandler(this);

        // View
        textViewMain = (TextView) findViewById(R.id.TextView_Main_1);
        textViewSecond = (TextView) findViewById(R.id.TextView_Second_1);

        // Buttons
        crashButton = (Button) findViewById(R.id.Button_Crash);
        clearButton = (Button) findViewById(R.id.Button_Clear);
        intentButton = (Button) findViewById(R.id.Button_Intent);

        // set an onClickListener for the buttons
        Listener.setup_Crash_Button_Listener(crashButton);
        Listener.setup_Clear_Button_Listener(clearButton);
        Listener.setup_Intent_Button_Listener(intentButton);

        // display the traces from SecondActivity
        textViewSecond.setText(entry.readFirst(1));

        // start writing to database to leave traces of the lifecycle
        // if the first table item is fresh, then begin on first line; otherwise, add new line
        if (entry.readFirst(0).length() < 2) {
            entry.insert("onCreate()", 0);
            entry.insert("", 1);
        } else {
            entry.insert(entry.readFirst(0) + "\n" + "onCreate()", 0);
            entry.insert(entry.readFirst(1) + "\n", 1);
        }
        data = entry.readFirst(0);

        // print the data to the screen
        textViewMain.setText(data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        entry.insert(entry.readFirst(0) + "\n" + "onStart()", 0);
        entry.insert(entry.readFirst(1) + "\n", 1);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }

    @Override
    protected void onResume() {
        super.onResume();
        entry.insert(entry.readFirst(0) + "\n" + "onResume()", 0);
        entry.insert(entry.readFirst(1) + "\n", 1);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }

    @Override
    protected void onPause() {
        super.onPause();
        entry.insert(entry.readFirst(0) + "\n" + "onPause()", 0);
        entry.insert(entry.readFirst(1) + "\n", 1);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }

    @Override
    protected void onStop() {
        super.onStop();
        entry.insert(entry.readFirst(0) + "\n" + "onStop()", 0);
        entry.insert(entry.readFirst(1) + "\n", 1);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        entry.insert(entry.readFirst(0) + "\n" + "onRestart()", 0);
        entry.insert(entry.readFirst(1) + "\n", 1);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        entry.insert(entry.readFirst(0) + "\n" + "onDestroy()", 0);
        entry.insert(entry.readFirst(1) + "\n", 1);
        textViewMain.setText(entry.readFirst(0));
        textViewSecond.setText(entry.readFirst(1));
    }
}
