package com.example.recycler;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private Item item;
    private TextView tvName;
    private ImageView imgDetailImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        tvName = findViewById(R.id.name);
        imgDetailImg = findViewById(R.id.imageView);

        item = (Item) getIntent().getSerializableExtra("item");

        tvName.setText(item.getName());
        imgDetailImg.setImageResource(item.getImage());

    }
}