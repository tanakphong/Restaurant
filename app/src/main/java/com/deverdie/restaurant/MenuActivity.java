package com.deverdie.restaurant;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.deverdie.restaurant.model.SaveInstanceState;

public class MenuActivity extends AppCompatActivity {

    private String table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                table = null;
            } else {
                table = extras.getString(SaveInstanceState.TABLE);
            }
        } else {
            table = savedInstanceState.getString(SaveInstanceState.TABLE);
        }
        Toast.makeText(getApplicationContext(),"Selete table: "+table,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString(SaveInstanceState.TABLE, table);
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
