package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;

import com.example.myapplication.Adapterss.OrdersAdapter;
import com.example.myapplication.Modelss.OrderModel;
import com.example.myapplication.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DbHelper helper = new DbHelper(this);
        ArrayList<OrderModel> list = helper.getOrders();
     OrdersAdapter adapter = new OrdersAdapter(list , this);
     binding.OrderRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.OrderRecyclerView.setLayoutManager(layoutManager);
    }
}