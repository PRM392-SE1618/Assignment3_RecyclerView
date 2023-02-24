package com.example.recycler.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler.R;
import com.example.recycler.adapters.CategoryAdapter;
import com.example.recycler.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private RecyclerView rcvCategory;
    private CategoryAdapter adapter;

    public CategoriesFragment() {
    }
    // TODO: Rename and change types and number of parameters
    public static CategoriesFragment newInstance(String param1, String param2) {
        CategoriesFragment fragment = new CategoriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcvCategory = view.findViewById(R.id.rcvCategories);
        adapter = new CategoryAdapter(view.getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 3);
        rcvCategory.setLayoutManager(gridLayoutManager);

        adapter.SetData(getCategories());
        rcvCategory.setAdapter(adapter);
    }

    private List<Category> getCategories(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("pharmacy", R.drawable.ic_pharmacy));
        categories.add(new Category("registry", R.drawable.ic_registry));
        categories.add(new Category("cartwheel", R.drawable.ic_cartwheel));
        categories.add(new Category("clothing", R.drawable.ic_clothes));
        categories.add(new Category("shoes", R.drawable.ic_shoes));
        categories.add(new Category("acccessories", R.drawable.ic_accessories));
        categories.add(new Category("baby", R.drawable.ic_baby));
        categories.add(new Category("home", R.drawable.ic_home));
        categories.add(new Category("patio & garden", R.drawable.ic_patiogarden));
        categories.add(new Category("game", R.drawable.ic_game));
        categories.add(new Category("laptop", R.drawable.ic_laptop));
        categories.add(new Category("taxi", R.drawable.ic_taxi));
        return categories;
    }
}
