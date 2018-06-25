package com.learn.sumit.pitanjali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {


  // ArrayList<Products> products=new ArrayList<>();
    ListView ls;
    String[] names={"a","b","c","d"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
         ls=findViewById(R.id.listview);
        /*products.add(new Products(1,"keshkanti",100,20.0));
        products.add(new Products(11,"keshkantia",1001,200.0));
        products.add(new Products(110,"keshkanti",10,20.2));*/
        //Toast.makeText(this, ""+products.get(2).product_name, Toast.LENGTH_SHORT).show();
        CustomAdapter adapter=new CustomAdapter(this,DataHolder.getData());

        ls.setAdapter(adapter);
        Toast.makeText(this, "Total Products: "+ls.getCount(), Toast.LENGTH_SHORT).show();
    }


}
