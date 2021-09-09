package com.example.retrofitnested;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DataAdapter adapter;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.card_recycler_view);
        adapter = new DataAdapter();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        loadData();
    }

    /**
     * API Server <a href="https://api.androidhive.info/">api.androidhive.info</a> was not trust by android
     * duo to their https certificate has expired
     */
    private void loadData() {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getMovies().enqueue(new Callback<ApiResult>() {
            @Override
            public void onResponse(Call<ApiResult> call, Response<ApiResult> response) {
                if (response.isSuccessful()) {
                    List<Contact> contactList = response.body().getContacts();
                    adapter.setArrayList(contactList);
                }
            }

            @Override
            public void onFailure(Call<ApiResult> call, Throwable t) {
                // SSL HandShake error duo to api server https certificate was expired
                t.printStackTrace();
            }
        });
    }
}