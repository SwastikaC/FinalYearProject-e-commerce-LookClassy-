package com.example.lookclassy.home.fragments;

import android.icu.util.ULocale;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lookclassy.R;
import com.example.lookclassy.api.response.Category;
import com.example.lookclassy.home.fragments.home.adapters.CategoryAdapter;
import com.example.lookclassy.utils.DataHolder;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    RecyclerView fullCatRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fullCatRV = view.findViewById(R.id.fullCatRV);
        if(DataHolder.categories != null){
            showCategoryView(DataHolder.categories);
        }
    }

    private void showCategoryView(List<Category> categories) {
        fullCatRV.setHasFixedSize(true);
        fullCatRV.setLayoutManager(new GridLayoutManager(getContext(), 4));
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories, getContext(), true);
        fullCatRV.setAdapter(categoryAdapter);
    }
}