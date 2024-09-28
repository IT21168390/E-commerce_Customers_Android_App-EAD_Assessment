package com.example.e_commercecustomers_ead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.e_commercecustomers_ead.fragments.ProductsFragment;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_products);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the activity's main layout (not the fragment layout)

        // Check if savedInstanceState is null to avoid overlapping fragments on orientation change
        if (savedInstanceState == null) {
            // Add the ProductsFragment to the container
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Create an instance of ProductsFragment
            ProductsFragment productsFragment = new ProductsFragment();

            // Replace the container with the fragment
            fragmentTransaction.replace(R.id.fragment_container, productsFragment);
            fragmentTransaction.commit();
        }
    }
}