package com.example.e_commercecustomers_ead.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commercecustomers_ead.R;
import com.example.e_commercecustomers_ead.models.Product;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<Product> cartItems;
    private OnItemRemovedListener onItemRemovedListener;

    public interface OnItemRemovedListener {
        void onItemRemoved(int position);
    }

    /*public CartAdapter(List<Product> cartItems) {
        this.cartItems = cartItems;
    }*/
    public CartAdapter(List<Product> cartItems, OnItemRemovedListener listener) {
        this.cartItems = cartItems;
        this.onItemRemovedListener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate cart item layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        // Get the product at the current position
        Product product = cartItems.get(position);

        // Bind the product data to the UI elements in the cart item layout
        holder.productName.setText(product.getName());
        holder.productPrice.setText("$" + product.getPrice());
        holder.productRating.setText("Rating: " + product.getRating());

        // Optionally, you can set the product image
        holder.productImage.setImageResource(product.getImageResource());

        // Set delete button click listener
        holder.deleteButton.setOnClickListener(v -> {
            onItemRemovedListener.onItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    // ViewHolder class for cart items
    public static class CartViewHolder extends RecyclerView.ViewHolder {

        public TextView productName, productPrice, productRating;
        public ImageView productImage;
        public ImageView deleteButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.cartProductName);
            productPrice = itemView.findViewById(R.id.cartProductPrice);
            productRating = itemView.findViewById(R.id.cartProductRating);
            productImage = itemView.findViewById(R.id.cartProductImage);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
