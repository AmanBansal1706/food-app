package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

import com.example.myapplication.Adapterss.MainAdapter;
import com.example.myapplication.Modelss.MainModel;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.dry , "Dry Manchurian" , "10" , "Dry Manchurian With Extra Cheese" ));
        list.add(new MainModel(R.drawable.manchuriangravy , "Gravy Manchurian" , "10" , "Gravy Manchurian With Extra Cheese" ));
        list.add(new MainModel(R.drawable.chaap , "Malai Chaap" , "12" , "Malai Soya chaap " ));
        list.add(new MainModel(R.drawable.friedrice , "Fried Rice" , "6" , "Veg and Chicken fried rice" ));
        list.add(new MainModel(R.drawable.burger , "Burger" , "7" , "Burger With Extra Cheese" ));
        list.add(new MainModel(R.drawable.pasta , "Pasta" , "5" , "Pasta With Extra Cheese" ));
        list.add(new MainModel(R.drawable.pizza1, "Pizza" , "8" , "Pizza With Extra Cheese" ));
        list.add(new MainModel(R.drawable.americandogs , "HotDog" , "7" , "Hotdog With Extra Cheese" ));
        list.add(new MainModel(R.drawable.chowmin1 , "Chowmin" , "4" , "Chowmin With Extra Cheese" ));

        MainAdapter adapter = new MainAdapter(list , this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.orders:
                startActivity(new Intent(MainActivity.this , OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}