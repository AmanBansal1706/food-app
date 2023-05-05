package com.example.myapplication.Adapterss;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DbHelper;
import com.example.myapplication.DetailActivity;
import com.example.myapplication.Modelss.OrderModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class OrdersAdapter extends  RecyclerView.Adapter<OrdersAdapter.viewHolder>{
    ArrayList<OrderModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrderModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample , parent,false);
        return  new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
     final  OrderModel model = list.get(position);
     holder.orderImage.setImageResource(model.getOrderImage());
       holder.soldItemName.setText(model.getSoldItems());
       holder.orderNumber.setText(model.getOrderNumber());
       holder.price.setText(model.getPrice());
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(context , DetailActivity.class);
              intent.putExtra("id" ,Integer.parseInt(model.getOrderNumber())) ;
              intent.putExtra("type" , 2);
          context.startActivity(intent);
          }
      });
      holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {
              new AlertDialog.Builder(context)
                      .setTitle("Delete Item")
                      .setMessage("Are you sure to delete")
                      .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              DbHelper helper = new DbHelper(context);
                              if (helper.deleteOrder(model.getOrderNumber()) > 0) {
                                  Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                              } else {
                                  Toast.makeText(context, "Not Deleted", Toast.LENGTH_SHORT).show();
                              }
                          }
                      })
                      .setPositiveButton("No", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {

                          }
                      }).show();

                  return false;
      }
      });

     }

@Override
    public int getItemCount() {
        return list.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
        TextView soldItemName , orderNumber , price;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage = itemView.findViewById(R.id.orderImage);
           soldItemName = itemView.findViewById(R.id.orderItemName);
          orderNumber = itemView.findViewById(R.id.OrderNumber);
            price = itemView.findViewById(R.id.ORDERPRICE);

        }
    }
}
