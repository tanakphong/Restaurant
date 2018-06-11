package com.deverdie.restaurant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.deverdie.restaurant.Interface.TableInterface;
import com.deverdie.restaurant.adapter.TableAdapter;
import com.deverdie.restaurant.model.TableRes;
import com.deverdie.restaurant.util.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableActivity extends AppCompatActivity implements TableAdapter.ItemClickListener {
    private static final String TAG = "dlg "+TableActivity.class.getSimpleName();
    private TableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


//        List<TableRes.DataBean> tables = new ArrayList<>();
//        tables.add(new TableRes.DataBean(1,"1", "โต๊ะกินข้าวไม้สไตล์โมเดิร์นที่คุณ", "http://pubmodule.space/admin/api/table/photos/1.jpg"));
//        tables.add(new TableRes.DataBean(2,"2", "โต๊ะกินข้าวไม้แบบคลา", "http://pubmodule.space/admin/api/table/photos/2.jpg"));
//        tables.add(new TableRes.DataBean(3,"3", "โต๊ะกินข้าวโมเดิร์นแบบไม้และเหล", "http://pubmodule.space/admin/api/table/photos/3.jpg"));
//        tables.add(new TableRes.DataBean(4,"4", "โต๊ะกินข้าวไม้แบบทร", "http://pubmodule.space/admin/api/table/photos/4.jpg"));
//        tables.add(new TableRes.DataBean(5,"5", "โต๊ะกินข้าวโมเดิร์นแบบไ", "http://pubmodule.space/admin/api/table/photos/5.jpg"));
//        tables.add(new TableRes.DataBean(6,"6", "โต๊ะกินข้าวไม้แบบยาวหรือแบบสี่เหล", "http://pubmodule.space/admin/api/table/photos/6.jpg"));

        RecyclerView recyclerView = findViewById(R.id.rvNumbers);

        adapter = new TableAdapter(getApplicationContext());

        recyclerView.setLayoutManager(new SpanningGridLayoutManager(this,2));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        getData();
    }

    private void getData() {
        TableInterface tableInterface = RetrofitClient.getClient().create(TableInterface.class);

        Call<TableRes> getAll = tableInterface.getAll();

        getAll.enqueue(new Callback<TableRes>() {
            @Override
            public void onResponse(@NonNull Call<TableRes> call, @NonNull Response<TableRes> response) {
                TableRes responseBody = response.body();
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse: Successfully.");
                    assert responseBody != null;
                    if (responseBody.isReturnX()) {
                        for (TableRes.DataBean dataBean : responseBody.getData()) {
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
                        case 403:
                            msg = getResources().getString(R.string.error_incorrect_password);
                            break;

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
            public void onFailure(@NonNull Call<TableRes> call, @NonNull Throwable t) {
                Log.e(TAG, "call tableInterface.getAll: failure.");
            }
        });
    }


    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position).getDesc() + ", which is at cell position " + position);
        Toast.makeText(getApplicationContext(),adapter.getItem(position).getId() ,Toast.LENGTH_SHORT).show();
    }

}
