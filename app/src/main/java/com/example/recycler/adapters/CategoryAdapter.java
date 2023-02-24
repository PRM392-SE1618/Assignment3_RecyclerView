package com.example.recycler.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler.R;
import com.example.recycler.models.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context mContext;
    private List<Category> categories;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void SetData(List<Category> categories){
        this.categories = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        if (category == null){
            return;
        }
        holder.imgCategory.setImageResource(category.getImageId());
        holder.txtCategoryName.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        if(categories == null){
            return 0;
        }
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgCategory;
        private TextView txtCategoryName;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCategory = itemView.findViewById(R.id.imgCategory);
            txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
        }
    }
}
