package com.example.foodmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodmeal.adapter.FoodsAdapter;
import com.example.foodmeal.data.FoodsData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodsAdapter adapter;
    private ArrayList<Foods> foodsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Resep Makanan");

        foodsList = new ArrayList<>();

    }

//    void addData(){
//        foodsArrayList = new ArrayList<>();
//        foodsArrayList.add(new Foods("Chicken Frish", "Beef"));
//        foodsArrayList.add(new Foods("Black Paper","Fruit"));
//        foodsArrayList.add(new Foods("Chill Black","Fruit"));
//    }

    private void showSelectedStartup(Foods a) {

        Intent intent = new Intent(MainActivity.this, DetailActivity.class){};
        intent.putExtra(DetailActivity.EXTRA_NAMES, a.getFoodName());
        intent.putExtra(DetailActivity.EXTRA_CATEGORY, a.getFoodCategory());
        intent.putExtra(DetailActivity.EXTRA_PHOTO, a.getFoodImage());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Membaca file menu dan menambahkan isinya ke action bar jika ada.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.app_bar_author:
                startActivity(new Intent(this, AuthorActivity.class));
                return true;
            default:
                return true;
        }
    }

    private void loadUrlData(String params) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + params;

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray array = jsonObject.getJSONArray("meals");

                    for (int i = 0; i < array.length(); i++){

                        JSONObject jo = array.getJSONObject(i);

                        Foods food = new Foods(jo.getString("strMeal"), jo.getString("strCategory"),
                                jo.getString("strMealThumb"));
                        foodsList.add(food);

                    }
                    recyclerView = findViewById(R.id.rv_foods);

                    adapter = new FoodsAdapter(foodsList);

                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);

                    recyclerView.setLayoutManager(layoutManager);

                    recyclerView.setAdapter(adapter);

                    adapter.setOnItemClickCallback(new FoodsAdapter.OnItemClickCallback() {

                        @Override
                        public void onItemClicked(Foods data) {
                            showSelectedStartup(data);
                        }
                    });

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void clickSearch(View view) {
        EditText inpSearch = findViewById(R.id.inp_search);
        loadUrlData(inpSearch.getText().toString());
    }
}
