package com.example.latuass;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.ProductAdapter;
import model.Product;

public class MainActivity extends AppCompatActivity {

    private List<Product> products = new ArrayList<>();
    private RecyclerView rvProduct;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvProduct = findViewById(R.id.rv_product);
        rvProduct.setLayoutManager(new LinearLayoutManager(this));

        products.add(new Product("oo", 1000, R.drawable.pic));
        products.add(new Product("oo", 1000, R.drawable.pic));
        products.add(new Product("oo", 1000, R.drawable.pic));

        adapter = new ProductAdapter(this, products);
        rvProduct.setAdapter(adapter);
    }
}