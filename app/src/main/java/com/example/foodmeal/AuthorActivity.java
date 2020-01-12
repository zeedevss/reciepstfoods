package com.example.foodmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodmeal.adapter.AuthorAdapter;
import com.example.foodmeal.data.AuthorData;

import java.util.ArrayList;


public class AuthorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AuthorAdapter adapter;
    private ArrayList<Author> authorArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        getSupportActionBar().setTitle("Tentang Kami");


        authorArrayList.addAll(AuthorData.getListAuthor());

        showRecyclerList();
    }

    private void showRecyclerList() {
        recyclerView = findViewById(R.id.rv_author);

        adapter = new AuthorAdapter(authorArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AuthorActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

}
