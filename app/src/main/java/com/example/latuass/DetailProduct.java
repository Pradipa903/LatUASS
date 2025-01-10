package com.example.latuass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class DetailProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageView = findViewById(R.id.image);
        TextView price = findViewById(R.id.price);
        TextView name = findViewById(R.id.name);

        int imageid = getIntent().getIntExtra("image", 0);
        int priceid = getIntent().getIntExtra("price", 0);
        String nameid = getIntent().getStringExtra("name");

        imageView.setImageResource(imageid);
        price.setText("Rp" +     priceid);
        name.setText(nameid);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}