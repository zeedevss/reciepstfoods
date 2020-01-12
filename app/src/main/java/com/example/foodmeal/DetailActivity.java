package com.example.foodmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAMES = "extra_name";
    public static final String EXTRA_CATEGORY = "extra_category";
    public static final String EXTRA_PHOTO = "extra_photo";

    private ImageView imgPhoto;
    private TextView tvName, tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tv_name_food);
        tvDetail = findViewById(R.id.tv_category_food);
        imgPhoto = findViewById(R.id.img_food);

        String name = getIntent().getStringExtra(EXTRA_NAMES);
        String category = getIntent().getStringExtra(EXTRA_CATEGORY);
        String photo = getIntent().getStringExtra(EXTRA_PHOTO);

        getSupportActionBar().setTitle(name);
        Picasso.with(this).load(photo).into(imgPhoto);
        tvName.setText(name);
        tvDetail.setText(category);
    }

}
