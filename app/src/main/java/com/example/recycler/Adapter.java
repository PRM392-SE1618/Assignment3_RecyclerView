package com.example.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<Item> items;

    public Adapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        if(items != null){
            return items.size();
        }
        return 0;
    }

    public class ItemViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imgItem;
        private TextView tvWord;
        private Adapter mAdapter;
        private Context context;

        public ItemViewHolder(@NonNull View itemView, Adapter adapter, Context context) {
            super(itemView);

            imgItem = itemView.findViewById(R.id.img_detail);
            tvWord = itemView.findViewById(R.id.tv_detail_word);

            this.mAdapter = adapter;
            this.context = context;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                Item item = items.get(position);
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("item", String.valueOf(item));
                context.startActivity(intent);
            }
        }
}
}
