package com.deverdie.restaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.deverdie.restaurant.adapter.RVAdapter;
import com.deverdie.restaurant.adapter.TableRecyclerViewAdapter;
import com.deverdie.restaurant.model.Person;

import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity implements TableRecyclerViewAdapter.ItemClickListener {

//    TableRecyclerViewAdapter adapter;

//    private RecyclerView recyclerView;
//    private EmployeeAdapter adapter;
//    private ArrayList<Employee> employeeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
//        // data to populate the RecyclerView with
//        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48"};
//
//
//        // set Reclerview Horizontal
//        LinearLayoutManager layoutManager
//                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        // set up the RecyclerView
//        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
//        int numberOfColumns = 2;
////        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setLayoutManager(new SpanningGridLayoutManager(this,numberOfColumns));
////        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
//        adapter = new TableRecyclerViewAdapter(this, data);
//        adapter.setClickListener(this);
//        recyclerView.setAdapter(adapter);
//        employeeArrayList = new ArrayList<>();
//        employeeArrayList.add(new Employee("Employee1", "emp1@example.com", "123456789"));
//        employeeArrayList.add(new Employee("Employee2", "emp2@example.com", "987654321"));
//        employeeArrayList.add(new Employee("Employee3", "emp3@example.com", "789456123"));
//        employeeArrayList.add(new Employee("Employee4", "emp4@example.com", "321654987"));
//
//        recyclerView = (RecyclerView) findViewById(R.id.rvNumbers);
//
//        adapter = new EmployeeAdapter(employeeArrayList);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TableActivity.this);
//
//        recyclerView.setLayoutManager(layoutManager);
//
//        recyclerView.setAdapter(adapter);

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.avatar));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.avatar2));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.avatar3));

        RecyclerView recyclerView =  findViewById(R.id.rvNumbers);

        RVAdapter adapter = new RVAdapter(persons);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
//        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);

    }

}
