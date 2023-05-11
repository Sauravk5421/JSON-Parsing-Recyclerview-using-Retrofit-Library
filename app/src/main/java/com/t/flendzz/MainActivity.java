package com.t.flendzz;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ApiInterface apiInterface;
    LinearLayoutManager layoutManager;
    RecyclerViewAdapter adapter;
    List<Models> userList = new ArrayList<>();
    List<Models> singleList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(userList);
        recyclerView.setAdapter(adapter);

        apiInterface = RetrofitInstance.getRetrofit().create((ApiInterface.class));
        apiInterface.getusers().enqueue(new Callback<List<Models>>() {
            @Override
            public void onResponse(Call<List<Models>> call, Response<List<Models>> response) {
                if(response.body().size()>0){
                    //Toast.makeText(MainActivity.this, "List is not Empty", Toast.LENGTH_SHORT).show();
                    userList.addAll(response.body());

                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "zero", Toast.LENGTH_SHORT).show();

                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                           // Toast.makeText(MainActivity.this, "item clicked", Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                             startActivity(intent);

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));




                }else
                {
                    Toast.makeText(MainActivity.this, "List is Empty", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Models>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("app", "response" + t.getLocalizedMessage());
            }
        });




    }

}