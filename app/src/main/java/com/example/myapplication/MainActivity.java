package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //private TextView Helloworld;
    private TextView Heading;
    private TextView Description;
    private TextView description;
    private Button Register;
    private Button Log_in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.homepage);

        //Helloworld = findViewById(R.id.Helloworld);
        Heading = findViewById(R.id.Heading);
        Description = findViewById(R.id.Description);
        Register = findViewById(R.id.Register);
        Log_in = findViewById(R.id.Log_in);

//        fetchMessageFromAPI();

        Log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sign_In.class);
                startActivity(intent);

            }
        });
    }

//    private void fetchMessageFromAPI() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:8000/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ApiService apiService = retrofit.create(ApiService.class);
//        apiService.getHello().enqueue(new Callback<HelloResponse>() {
//            @Override
//            public void onResponse(Call<HelloResponse> call, Response<HelloResponse> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    Helloworld.setText(response.body().message);
//                } else {
//                    Helloworld.setText("Error: No message");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<HelloResponse> call, Throwable t) {
//                Helloworld.setText("Failed to connect");
//                Log.e("FastAPI", "API call failed", t);
//            }
//        });
    }
//}