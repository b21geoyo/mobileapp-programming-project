package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=b21geoyo";
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Items> itemsList = new ArrayList<>();
        myAdapter = new MyAdapter(itemsList);

        recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new JsonTask(this).execute(JSON_URL);

        //RecyclerView recyclerView;

    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
    }
}
