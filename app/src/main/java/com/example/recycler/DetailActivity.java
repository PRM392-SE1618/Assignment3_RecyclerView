package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private Item item;
    private TextView tvDetailWord;
    private ImageView imgDetailImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item_view);

        tvDetailWord = findViewById(R.id.tv_detail_word);
        imgDetailImg = findViewById(R.id.img_detail);

        item = (Item) getIntent().getSerializableExtra("item");

        tvDetailWord.setText(item.getName());
        imgDetailImg.setImageResource(item.getImage());
    }
}
