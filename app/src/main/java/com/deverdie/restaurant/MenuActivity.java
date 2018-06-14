package com.deverdie.restaurant;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.deverdie.restaurant.Interface.MenuInterface;
import com.deverdie.restaurant.adapter.MenuAdapter;
import com.deverdie.restaurant.model.MenuRes;
import com.deverdie.restaurant.model.SaveInstanceState;
import com.deverdie.restaurant.util.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity implements MenuAdapter.ItemClickListener {

    private SearchView searchView;

    private static final String TAG = MenuActivity.class.getSimpleName();
    private String table;
    private MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_menu);
        setContentView(R.layout.activity_menu_with_search);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // toolbar fancy stuff
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);

//        if (savedInstanceState == null) {
//            Bundle extras = getIntent().getExtras();
//            if (extras == null) {
//                table = null;
//            } else {
//                table = extras.getString(SaveInstanceState.TABLE);
//            }
//        } else {
//            table = savedInstanceState.getString(SaveInstanceState.TABLE);
//        }
//        Toast.makeText(getApplicationContext(),"Selete table: "+table,Toast.LENGTH_SHORT).show();
//
        RecyclerView recyclerView = findViewById(R.id.recycler);

        // white background notification bar
        whiteNotificationBar(recyclerView);

        adapter = new MenuAdapter(getApplicationContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        getData();
    }



    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    private void getData() {
        MenuInterface menuInterface = RetrofitClient.getClient().create(MenuInterface.class);

        Call<MenuRes> getAll = menuInterface.getAll();

        getAll.enqueue(new Callback<MenuRes>() {
            @Override
            public void onResponse(@NonNull Call<MenuRes> call, @NonNull Response<MenuRes> response) {
                MenuRes responseBody = response.body();
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse: Successfully.");
                    assert responseBody != null;
                    if (responseBody.isReturnX()) {
                        for (MenuRes.DataBean dataBean : responseBody.getData()) {
                            adapter.add(dataBean);
                        }
                        adapter.notifyDataSetChanged();
//                        Log.d(TAG, "onResponse: " + responseBody.getData().getUsr_code());
//                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                } else {
                    Log.e(TAG, "" + response.code() + " " + response.message());
                    String msg;
                    switch (response.code()) {
                        case 404:
                            msg = getResources().getString(R.string.error_invalid_username);
                            break;
                        default:
                            msg = "";

                    }
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<MenuRes> call, @NonNull Throwable t) {
                Log.e(TAG, "call tableInterface.getAll: failure.");
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString(SaveInstanceState.TABLE, table);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getApplicationContext(), adapter.getItem(position).getDesc(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // close search view on back button pressed
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
}
