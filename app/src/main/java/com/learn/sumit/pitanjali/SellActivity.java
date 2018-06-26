package com.learn.sumit.pitanjali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SellActivity extends AppCompatActivity {

    EditText name,namesearch,quanity,price,selldemand;
    Button search,sell;
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
        sell= findViewById(R.id.sell);
        selldemand = findViewById(R.id.selldemand);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(namesearch.getText().toString().equals("")) namesearch.setError("Please enter name");
                    else{
                    products=DataHolder.getData();
                    for(int i=0;i<products.size();i++){
                        if(products.get(i).product_name.equals(namesearch.getText().toString())){
                            flag=i;
                            //Toast.makeText(SellActivity.this, "Product found", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            Toast.makeText(SellActivity.this, "No such product found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    if(flag!=-1){

                           name.setText("Name:  "+products.get(flag).product_name+"");
                        quanity.setText("Stock: "+products.get(flag).product_stock+"");
                          price.setText("Rate:  "+products.get(flag).product_rate+"");
                    }


                }
            }
        });
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=selldemand.getText().toString();
                int se=Integer.parseInt(s);
                if(s.equals("")||flag==-1) {
                    if(s.equals("")) selldemand.setError("please enter quantity to sell");
                    if(flag==-1)
                        Toast.makeText(SellActivity.this, "No product selected", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(products.get(flag).product_stock.equals(0))
                        Toast.makeText(SellActivity.this, "Item out of stock", Toast.LENGTH_SHORT).show();
                    if(se>products.get(flag).product_stock) selldemand.setError("insufficent stock");
                    else{
                        products.get(flag).product_stock=products.get(flag).product_stock-se;
                        name.setText("");
                        quanity.setText("");
                        price.setText("");
                        selldemand.setText("");
                        name.setText("");
                        flag=-1;
                        Toast.makeText(SellActivity.this, "Item sold", Toast.LENGTH_SHORT).show();


                    }

                }

            }
        });
    }

}
