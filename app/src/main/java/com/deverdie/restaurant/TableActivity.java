package com.deverdie.restaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.deverdie.restaurant.adapter.TableAdapter;
import com.deverdie.restaurant.model.TableRes;

import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity implements TableAdapter.ItemClickListener {
    private TableAdapter adapter;


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

//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.avatar));
//        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.avatar2));
//        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.avatar3));
//
//        RecyclerView recyclerView =  findViewById(R.id.rvNumbers);
//
//        RVAdapter adapter = new RVAdapter(persons);
//
//        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(llm);
//
//        recyclerView.setAdapter(adapter);


        List<TableRes> tables = new ArrayList<>();
        tables.add(new TableRes(1,"1", "โต๊ะกินข้าวไม้สไตล์โมเดิร์นที่คุณ", "http://pubmodule.space/admin/api/table/photos/1.jpg"));
        tables.add(new TableRes(2,"2", "โต๊ะกินข้าวไม้แบบคลา", "http://pubmodule.space/admin/api/table/photos/2.jpg"));
        tables.add(new TableRes(3,"3", "โต๊ะกินข้าวโมเดิร์นแบบไม้และเหล", "http://pubmodule.space/admin/api/table/photos/3.jpg"));
        tables.add(new TableRes(4,"4", "โต๊ะกินข้าวไม้แบบทร", "http://pubmodule.space/admin/api/table/photos/4.jpg"));
        tables.add(new TableRes(5,"5", "โต๊ะกินข้าวโมเดิร์นแบบไ", "http://pubmodule.space/admin/api/table/photos/5.jpg"));
        tables.add(new TableRes(6,"6", "โต๊ะกินข้าวไม้แบบยาวหรือแบบสี่เหล", "http://pubmodule.space/admin/api/table/photos/6.jpg"));

        RecyclerView recyclerView = findViewById(R.id.rvNumbers);

         adapter = new TableAdapter(getApplicationContext(), tables);

//        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(llm);
        recyclerView.setLayoutManager(new SpanningGridLayoutManager(this,2));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position).getDesc() + ", which is at cell position " + position);
        Toast.makeText(getApplicationContext(),adapter.getItem(position).getDesc() ,Toast.LENGTH_SHORT).show();
    }

}
