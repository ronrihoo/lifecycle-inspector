package com.comets.lifecycleinspector.service;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.comets.lifecycleinspector.MainActivity;
import com.comets.lifecycleinspector.SecondActivity;
import com.comets.lifecycleinspector.Util.Config;

public class Listener {

    public static void setup_Crash_Button_Listener(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // anything to just crash the app -- this will do
                Config.context.entry.crash();
            }
        });
    }

    public static void setup_Clear_Button_Listener(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // delete the one and only item in the table
                Config.context.entry.delete(0);
                Config.context.entry.delete(1);
                // refresh the TextView
                Config.context.textViewMain.setText(Config.context.entry.readFirst(0));
                Config.context.textViewSecond.setText(Config.context.entry.readFirst(1));
            }
        });
    }

    public static void setup_Intent_Button_Listener(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Config.context.getApplicationContext(),
                        SecondActivity.class);
                Config.context.startActivity(intent);
            }
        });
    }

    public static void setup_Back_Button_Listener(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Config.secondActivityContext.getApplicationContext(),
                        MainActivity.class);
                Config.secondActivityContext.startActivity(intent);
                Config.secondActivityContext.finish();
            }
        });
    }
}
