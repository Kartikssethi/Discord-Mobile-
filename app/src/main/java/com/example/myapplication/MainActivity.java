package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView Helloworld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Helloworld = findViewById(R.id.Helloworld);

        fetchMessageFromAPI();
    }

    private void fetchMessageFromAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getHello().enqueue(new Callback<HelloResponse>() {
            @Override
            public void onResponse(Call<HelloResponse> call, Response<HelloResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Helloworld.setText(response.body().message);
                } else {
                    Helloworld.setText("Error: No message");
                }
            }

            @Override
            public void onFailure(Call<HelloResponse> call, Throwable t) {
                Helloworld.setText("Failed to connect");
                Log.e("FastAPI", "API call failed", t);
            }
        });
    }
}