package com.deverdie.restaurant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.deverdie.restaurant.adapter.MainMenuAdapter;
import com.deverdie.restaurant.model.MainMenuRes;

public class MainActivity extends AppCompatActivity implements MainMenuAdapter.ItemClickListener  {

    private MainMenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);

        adapter = new MainMenuAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        getData();
    }

    private void getData() {

        @SuppressLint("Recycle") TypedArray ico = getResources().obtainTypedArray(R.array.menu_icon);
        String[] data = getResources().getStringArray(R.array.menu_desc);

        for (int i = 0; i < data.length; i++) {
            adapter.add(new MainMenuRes(ico.getResourceId(i, -1), data[i]));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this,TableActivity.class));
                break;
        }
    }
}
