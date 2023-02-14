package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvItems;
    private Adapter adt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<>();
        items.add(new Item("Pharmarcy",R.drawable.ic_baseline_local_pharmacy_24));
        items.add(new Item("Soup",R.drawable.ic_baseline_soup_kitchen_24));
        items.add(new Item("Gift",R.drawable.ic_baseline_card_giftcard_24));
        items.add(new Item("Home",R.drawable.ic_baseline_home_24));
        items.add(new Item("Hamburger",R.drawable.ic_baseline_lunch_dining_24));
        items.add(new Item("Baby",R.drawable.ic_baseline_child_friendly_24));

        recyclerView.setLayoutManager((new GridLayoutManager(this,3)));
        recyclerView.setAdapter(new Adapter(getApplicationContext(),items));
    }

}