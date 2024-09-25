package com.example.e_commercecustomers_ead.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.e_commercecustomers_ead.R;
import com.example.e_commercecustomers_ead.adapters.ProductAdapter;
import com.example.e_commercecustomers_ead.models.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        // Initialize the RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewProducts);

        // Set the LayoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // Two columns

        // Load the product data (make sure this is done before setting the adapter)
        loadProducts();

        // Initialize and set the adapter
        productAdapter = new ProductAdapter(getContext(), productList);
        recyclerView.setAdapter(productAdapter);

        return view;
    }


    private void loadProducts() {
        // Dummy product data
        productList = new ArrayList<>(); // Make sure the list is initialized

        productList.add(new Product("Product 1", "Electronics", "Best in the market", "John Marston", 4.5, 50.00, R.drawable.ic_star_filled));
        productList.add(new Product("Product 2", "Electronics", "Best in the market", "John Marston", 4.0, 45.00, R.drawable.ic_star_filled));
        productList.add(new Product("Product 3", "Electronics", "Best in the market", "John Marston", 3.5, 30.00, R.drawable.ic_star_filled));
        // Add more products here
    }

}
