package com.learn.sumit.pitanjali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SellActivity extends AppCompatActivity {

    EditText name,namesearch,quanity,price;
    Button search;
    ArrayList<Products> products;
    int flag=-1;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        setContentView(R.layout.activity_sell);
        name=findViewById(R.id.name);
        namesearch= findViewById(R.id.nameSearch);
        quanity= findViewById(R.id.quantity);
        price= findViewById(R.id.price);
        search= findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                products=DataHolder.getData();
                for(int i=0;i<products.size();i++){
                    if(products.get(i).product_name.equals(namesearch.getText().toString())){
                       flag=i;
                        break;
                    }
                    else {
                        Toast.makeText(SellActivity.this, "No such product found", Toast.LENGTH_SHORT).show();
                    }
                }

                if(flag!=-1){

                    name.setText(products.get(flag).product_name+"");
                    quanity.setText(products.get(flag).product_stock+"");
                    price.setText(products.get(flag).product_rate+"");


                }

                search.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

            }
        });
    }

}
