package com.t.flendzz;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkConnection();

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

                }else
                {
                    Toast.makeText(MainActivity.this, "List is Empty", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Models>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                //Log.d("app", "response" + t.getLocalizedMessage());
            }
        });

    }

    public void checkConnection(){
        ConnectivityManager manager = ((ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo  activeNetwork = manager.getActiveNetworkInfo();

        if(null!= activeNetwork){
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                Toast.makeText(MainActivity.this, "WiFi Enabled", Toast.LENGTH_SHORT).show();
            }
            else if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(MainActivity.this, "Data Enabled", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }

    }


}