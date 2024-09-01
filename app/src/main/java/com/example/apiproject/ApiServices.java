package com.example.apiproject;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ApiServices apiServices;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textApi);
        apiServices= ApiClient.getretrofit().create(ApiServices.class);
        //   Call<ArrayList<ApiModelClass>>CallList=ApiServices.getpostList();
        Call<ArrayList<ApiModelClass>>callist=apiServices.getpostList();
        callist.enqueue(new Callback<ArrayList<ApiModelClass>>() {
            @Override
            public void onResponse(Call<ArrayList<ApiModelClass>> call, Response<ArrayList<ApiModelClass>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"error" +response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuilder stringBuilder=new StringBuilder();
                for (ApiModelClass apiModelClass:response.body()){
//
                    stringBuilder.append("id" + ApiModelClass.getId()+"\n");
                    stringBuilder.append("userid" + ApiModelClass.getUserId()+"\n");
                    stringBuilder.append("Tittle" +ApiModelClass.getTittle()+"\n");
                    stringBuilder.append("Body" +ApiModelClass.getBody()+"\n");




                }
                textView.setText(stringBuilder);
            }

            @Override
            public void onFailure(Call<ArrayList<ApiModelClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}