package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DbHelper helper = new DbHelper(this);

        if (getIntent().getIntExtra("type" ,0) == 1) {
            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");
            binding.detailImage.setImageResource(image);
            binding.priceLBL.setText(String.format("%d", price));
            binding.nameBox.setText(name);
            binding.orderDEScription.setText(description);

            binding.toggleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = helper.inserOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Data Inserted ", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Error ", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            int id = getIntent().getIntExtra("id" ,0);
            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(4);
            binding.detailImage.setImageResource(cursor.getInt(4));
            binding.priceLBL.setText(String.format("%d", cursor.getInt(3)));
            binding.nameBox.setText(cursor.getString(6));
            binding.orderDEScription.setText(cursor.getString(5));

             binding.nameBox.setText(cursor.getString(1));
             binding.phoneBox.setText(cursor.getString(2));
             binding.toggleButton.setText("Update Now");
             binding.toggleButton.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
              boolean isUpdated =  helper.updateOrder(binding.nameBox.getText().toString(),
                                 binding.phoneBox.getText().toString() ,
                         Integer.parseInt(binding.priceLBL.getText().toString()),
                       image,
                       binding.orderDEScription.getText().toString(),
                       binding.priceLBL.getText().toString(),
                  1,
                       id
                       );
               if(isUpdated){
                   Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
               } else{
                   Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
               }
                 }
             });
        }
    }
}