package com.learn.sumit.pitanjali;

import android.app.Activity;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Products> {
    ArrayList<Products> products;
    Activity activity;

    public CustomAdapter( Activity activity,ArrayList<Products> productsArrayList) {
        super(activity,R.layout.list_layout,productsArrayList);
        this.products = productsArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater=activity.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.list_layout,null);
        TextView t1=view.findViewById(R.id.id);
        TextView t2=view.findViewById(R.id.name);
        TextView t3=view.findViewById(R.id.stock);
        TextView t4=view.findViewById(R.id.rate);
        t1.setText(products.get(position).product_id.toString());
        t2.setText(products.get(position).product_name.toString());
        t3.setText(products.get(position).product_stock.toString());
        t4.setText(products.get(position).product_rate.toString());

        return view;
    }
}






/*
public class CustomAdapter extends ArrayAdapter<Products> {

    ArrayList<Products> products;
    Activity activity;
    public CustomAdapter(Activity activity,ArrayList<Products> productsArrayList){
        super(activity,R.layout.list_layout,productsArrayList);
        this.products=productsArrayList;
        this.activity=activity;
        Toast.makeText(activity, "Custom ka const chla", Toast.LENGTH_SHORT).show();
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Toast.makeText(activity, "getview chla", Toast.LENGTH_SHORT).show();
        LayoutInflater inflater= activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.list_layout,null);


        TextView id=v.findViewById(R.id.text1);
        TextView name=v.findViewById(R.id.text2);

        TextView rate=v.findViewById(R.id.text3);

        id.setText(products.get(position).product_id);
        rate.setText(products.get(position).product_rate.toString());
        name.setText(products.get(position).product_name.toString());



        return v;
    }
}
*/
