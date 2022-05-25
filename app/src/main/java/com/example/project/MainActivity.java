package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, about.class));
            }
        });

    }

    @Override
    public void onPostExecute(String json) {
        Log.d("TEST", "onPostExecute: " + json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Items>>(){}.getType();
        ArrayList<Items> tmpList = gson.fromJson(json, type);
        Log.d("TEST", "onPostExecute: " + tmpList.toString());
        myAdapter.setItemsList(tmpList);
        myAdapter.notifyDataSetChanged();
    }
}
